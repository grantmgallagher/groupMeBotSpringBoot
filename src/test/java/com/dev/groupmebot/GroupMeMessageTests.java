package com.dev.groupmebot;

import com.dev.groupmemodel.GroupMeMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = GroupMeMessage.class)
public class GroupMeMessageTests {

    private static final Logger logger = LogManager.getLogger(BotTests.class);

    final String ObamaPic = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/President_Barack_Obama.jpg/440px-President_Barack_Obama.jpg";

    @Test
    void testSimple()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            GroupMeMessage m = objectMapper.readValue(new File("src/test/resources/simpleMessage.json"), GroupMeMessage.class);

            //Standard Bodies
            assertTrue(m.getAttachments().isEmpty());
            assertTrue(m.getAvatarUrl().equals(ObamaPic));
            assertTrue(m.getCreatedAt() == 1590020636);
            assertTrue(m.getFavoritedBy().size() == 1);
            assertTrue(m.getFavoritedBy().get(0) == 12345678);
            assertTrue(m.getGroupId().equals("12345678"));
            assertTrue(m.getId().equals("123456789012345678"));
            assertTrue(m.getName().equals("BotTest"));
            assertTrue(m.getSenderId().equals("123456"));
            assertTrue(m.getSenderType().equals("bot"));
            assertTrue(m.getSourceGuid().equals("c699149c-9af9-11ea-bb37-0242ac130002"));
            assertTrue(m.getSystem().equals(false));
            assertTrue(m.getText().equals("Wowzers"));
            assertTrue(m.getUserId().equals("123456"));
            assertTrue(m.getPlatform().equals("gm"));
        }
        catch (Exception e)
        {
            logger.info("Error encountered deserializing: " + e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void testMention()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            GroupMeMessage m = objectMapper.readValue(new File("src/test/resources/mentionMessage.json"), GroupMeMessage.class);

            //Standard stuff
            assertTrue(m.getAvatarUrl().equals(ObamaPic));
            assertTrue(m.getCreatedAt() == 1590020636);
            assertTrue(m.getFavoritedBy().size() == 0);
            assertTrue(m.getGroupId().equals("12345678"));
            assertTrue(m.getId().equals("123456789012345678"));
            assertTrue(m.getName().equals("Tester"));
            assertTrue(m.getSenderId().equals("12345678"));
            assertTrue(m.getSenderType().equals("user"));
            assertTrue(m.getSourceGuid().equals("c699149c-9af9-11ea-bb37-0242ac130002"));
            assertTrue(m.getSystem().equals(false));
            assertTrue(m.getText().equals("@Test this is a test"));
            assertTrue(m.getUserId().equals("12345678"));
            assertTrue(m.getPlatform().equals("gm"));

            //Mentions testing
            assertTrue(!m.getAttachments().isEmpty());
            assertTrue(m.getAttachments().get(0).getType().equals("mentions"));
            assertTrue(m.getAttachments().get(0).getUserIds().get(0).equals("12345678"));
            assertTrue(m.getAttachments().get(0).getLoci().get(0).get(0) == 0);
            assertTrue(m.getAttachments().get(0).getLoci().get(0).get(1) == 5);

        }catch (UnsupportedOperationException e)
        {
            logger.info("Wrong Message Type Parsed");
            Assertions.fail(e.getMessage());
        }
        catch (Exception e)
        {
            logger.info("Error encountered " + e.getMessage());
            Assertions.fail("Mentions Test has failed");
        }
    }

    @Test
    void testImage()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            GroupMeMessage m = objectMapper.readValue(new File("src/test/resources/imageMessage.json"), GroupMeMessage.class);

            //Standard stuff
            assertTrue(m.getAvatarUrl().equals(ObamaPic));
            assertTrue(m.getCreatedAt() == 1590020636);
            assertTrue(m.getFavoritedBy().size() == 1);
            assertTrue(m.getFavoritedBy().get(0) == 87654321);
            assertTrue(m.getGroupId().equals("12345678"));
            assertTrue(m.getId().equals("123456789012345678"));
            assertTrue(m.getName().equals("Test"));
            assertTrue(m.getSenderId().equals("12345678"));
            assertTrue(m.getSenderType().equals("user"));
            assertTrue(m.getSourceGuid().equals("c699149c-9af9-11ea-bb37-0242ac130002"));
            assertTrue(m.getSystem().equals(false));
            assertTrue(m.getText() == null);
            assertTrue(m.getUserId().equals("12345678"));
            assertTrue(m.getPlatform().equals("gm"));

            // Image testing
            assertTrue(m.getAttachments().get(0).getType().equals("image"));
            assertTrue(m.getAttachments().get(0).getURL().equals(ObamaPic));
        }
        catch (UnsupportedOperationException e)
        {
            logger.info("Wrong Message Type Parsed");
            Assertions.fail(e.getMessage());
        }
        catch (Exception e)
        {
            logger.info("Error encountered " + e.getMessage());
            Assertions.fail("Image Test has failed");
        }
    }

}
