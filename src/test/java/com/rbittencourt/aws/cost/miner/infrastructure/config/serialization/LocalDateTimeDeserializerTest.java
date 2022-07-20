package com.rbittencourt.aws.cost.miner.infrastructure.config.serialization;

import com.fasterxml.jackson.core.JsonParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class LocalDateTimeDeserializerTest {

    @Mock
    JsonParser parser;

    @InjectMocks
    LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer();

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldDeserializeKnowDateTimeFormats() throws IOException {
        var date = "2022/06/01 00:00:00";
        given(parser.readValueAs(String.class)).willReturn(date);
        var deserializedDateTime = deserializer.deserialize(parser,null);
        assertNotNull(deserializedDateTime);
    }
}