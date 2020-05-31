package com.dev.groupmebot;

import com.dev.groupmemodel.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
public class Bot {

    private static final Logger logger = LogManager.getLogger(Bot.class);
    private final String baseUrl = "https://api.groupme.com/v3";
    private final String insultUrl = "https://evilinsult.com/generate_insult.php?lang=en&type=json";
    private final String complimentUrl = "https://complimentr.com/api";

    String botID;
    String groupID;
    String superKey;

    Bot() {
        botID = System.getenv("botID");
        groupID = System.getenv("groupID");
        superKey = System.getenv("superKey");
    }

    @GetMapping
    public String home()
    {
        return "Hello, welcome to the GroupMe Bot!";
    }

    @PostMapping(value = "/" , consumes = "application/json")
    public void index(@RequestBody GroupMeMessage message) {


        //Make sure the comment was neither empty nor made by another bot
        if (!message.getText().isEmpty() && !message.getSenderType().equals("bot")) {

            //Grab the comment from the message
            String gmComment = message.getText();

            //Potential Enhancement: Switch this to a more extensible solution
            //If somebody requested for us to insult or compliment somebody, do that
            if (gmComment.contains("Bot, insult @") || (gmComment.contains("Bot, compliment @"))) {
                logger.info("Bot activating to respond");

                //Potential Enhancement: Change this a List of strings so you can respond to multiple people at once
                //Figure out who to send the message to
                String recipientID = getRecipient(message.getAttachments());
               String recipientName = "";
                try {
                    recipientName = getRecipientName(recipientID);
                }
                catch (Exception e)
                {
                    //If we can't get the name, just populate it with a placeholder
                    recipientName = "Steve";
                }
                String response;

                //Get the compliment or insult
                if (gmComment.contains("insult"))
                    response = getInsult();
                else
                    response = getCompliment();

                //Respond to our recipient
                respondToRecipient(recipientID, recipientName, response);
            }
        }
    }

    private String getRecipient(List<GroupMeAttachment> attachments)
    {
        //Potential Enhancement: Allow this to return more than 1
        return attachments.get(0).getUserIds().get(0);
    }

    public String getRecipientName(String recipientID) throws JsonProcessingException {
        String recipName ="";

        //Set up the response handler
        RestTemplate restTemplate = new RestTemplate();

        //Construct URL
        String groupEndpointUrl = this.baseUrl + "/groups/" + this.groupID + this.superKey;

        //Get the response
        GroupMeGroupResponseEnvelope response = restTemplate.getForObject(groupEndpointUrl, GroupMeGroupResponseEnvelope.class);

        GroupMeGroup group = response.getResponse();

        List<GroupMeMember> members = group.getMembers();

        for (GroupMeMember member: members)
        {
            if (member.getUserId().equals(recipientID))
            {
                logger.info("User ID found for " + member.getName());
                recipName = member.getName();
                break;
            }
        }

        return recipName;
    }

    private void respondToRecipient(String recipientID, String recipientName, String text)
    {
        //set up a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        //Set up a header set to JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Create a BotPostMessage and populate it with our info
        BotPostMessage message = new BotPostMessage();

        message.setBotId(this.botID);
        message.setText("@" + recipientName + ", " + text);

        //Construct the attachment
        GroupMeAttachment mentionsAttachment = new GroupMeAttachmentMention();
        List<String> mentionList = mentionsAttachment.getUserIds();
        mentionList.add(recipientID);

        List<List<Integer>> loci = mentionsAttachment.getLoci();
        List<Integer> mentionLoci = new ArrayList<Integer>();
        mentionLoci.add(0);
        mentionLoci.add(recipientName.length());
        loci.add(mentionLoci);

        //Construct the URL
        String botPostURL = this.baseUrl + "/bots/post" + this.superKey;

        //submit the message
        HttpEntity request = new HttpEntity(message, headers);

        String resp = restTemplate.postForObject(botPostURL, request, String.class);
    }

    //Gets a compliment to send out to people
    public String getCompliment()
    {
        //Set up the response handler
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        //Get the response
        Compliment compliment = restTemplate.getForObject(complimentUrl, Compliment.class);

        //Pass the String response back
        logger.info("Compliment received is " + compliment.getCompliment());
        return compliment.getCompliment();
    }

    //Gets an insult from the API to send out to people
    public String getInsult()
    {
        //Set up the response handler
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        //Get the response
        Insult insult = restTemplate.getForObject(insultUrl, Insult.class);

        //Pass the String response back
        logger.info("Insult received is " + insult.getInsult());
        return insult.getInsult();
    }
}
