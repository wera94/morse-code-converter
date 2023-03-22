package pl.sdacademy.converter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

    class MorseCodeEncoderTest {

        private final MorseCodeDictionary dictionary = new MorseCodeDictionary();
        private final MorseCodeEncoder encoder = new MorseCodeEncoder(dictionary);

        @Test
        void testEncodeSuccess() {
            // given
            final String text = "HEY SDA";
            final String expectedCode = ".... . -.--   ... -.. .-";

            // when
            final String actualCode = encoder.encode(text);

            // then
            Assertions.assertEquals(expectedCode, actualCode);
        }

        public static Stream<Arguments> paramsProvider() {
            return Stream.of(
                    //  String input, String expectedCode
                    Arguments.of("SDA", "... -.. .-"),
                    Arguments.of("SOS", "... --- ..."),
                    Arguments.of("JAVA", ".--- .- ...- .-"),
                    Arguments.of("HEY SDA", ".... . -.--   ... -.. .-"),
                    Arguments.of("JAVA ROCKS", ".--- .- ...- .-   .-. --- -.-. -.- ..."),
                    Arguments.of("I LOVE JAVA", "..   .-.. --- ...- .   .--- .- ...- .-"),
                    Arguments.of("SOFTWARE DEVELOPMENT ACADEMY", "... --- ..-. - .-- .- .-. .   -.. . ...- . .-.. --- .--. -- . -. -   .- -.-. .- -.. . -- -.--")
            );
        }

        @ParameterizedTest
        @MethodSource("paramsProvider")
        void testEncodeHappyPath(String input, String expectedCode) {

            // when
            final String actualCode = encoder.encode(input);

            // then
            Assertions.assertEquals(expectedCode, actualCode);
        }

    }

