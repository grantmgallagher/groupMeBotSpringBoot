package com.dev.groupmebot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Bot.class)
public class BotTests {

    private static final Logger logger = LogManager.getLogger(BotTests.class);

    @Test
    void testGetCompliment()
    {
        Bot bot = new Bot();
        String comp = bot.getCompliment();
        logger.info("Compliment received was " + comp);
        assertTrue(!comp.isEmpty());
    }

    @Test
    void testGetInsult()
    {
        Bot bot = new Bot();
        String ins = bot.getCompliment();
        logger.info("Insult received was " + ins);
        assertTrue(!ins.isEmpty());
    }



}
