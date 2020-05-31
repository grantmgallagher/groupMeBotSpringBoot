package com.dev.groupmebot;

import com.dev.groupmemodel.GroupMeGroup;
import com.dev.groupmemodel.GroupMeGroupResponseEnvelope;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest(classes = GroupMeGroup.class)
public class GroupMeGroupTests {

    @Test
    void TestCreation()
    {
        //Init the object
        ObjectMapper objectMapper = new ObjectMapper();
        GroupMeGroupResponseEnvelope resp = null;
        try {
            resp = objectMapper.readValue(new File("src/test/resources/groupResponse.json"), GroupMeGroupResponseEnvelope.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GroupMeGroup g = resp.getResponse();

        assert(g.getId().equals("12345678"));
        assert(g.getName().equals("TestingGroup"));
        assert(g.getMembers().size()==3);
        assert(g.getMembers().get(0).getName().equals("AdminTest"));
    }
}
