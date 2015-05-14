import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FonetikAppTest {
    String[][] testCases = {
            {"dzsó", "joe"},
            {"vészi", "waysee"},
            {"zsuzsa", "shusha"},
            {"gól", "goal"},
            {"juli", "yulee"},
            {"halácsy", "halaachy"},
            {"lászló", "laasloe"},
            {"lacika", "latseeka"},
            {"szabolcs", "sabolch"},
            {"török", "toeroek"},
            {"budapest", "budapesht"},
            {"zsolt", "sholt"},
            {"mátyás", "maatyaash"},
            {"trencséni", "trenchaynee"},
            {"attila", "atteela"},
            {"gazsó", "gashow"},
            {"ács", "aatch"},
            {"gida", "gida"},
            {"balázs", "balaash"},
            {"péter", "payter"},
            {"peti", "petty"},
            {"bajorics", "baioreetch"},
            {"haraszthy", "haarasthy"},
            {"menedzser", "manager"},
            {"köszönöm", "koessonom"},
            {"köszi", "kossy"},
            {"józsi", "yoashee"},
            {"gábor", "gahbor"},
            {"és", "ayesh"},
            {"eredmény", "eredmayn"},
            {"Szijjártó", "Seeyyaartoe"},
            {"bassz", "bahss"},
            {"sípos", "sheeposh"},
            {"kovács", "kovaatch"},
            {"máté", "maatey"},
            {"csütörtökön", "chuetoertoekoen"},
            {"este", "ashte"},
            {"titkosították", "teetkosheetottaahk"},
            {"szele", "seleh"},
            {"tóthfalussy", "toathfalooshy"},
            {"szilveszter", "sylvester"},
            {"józsa", "yosha"},
            {"vajda", "wai-da"},
            {"csaj", "chai"},
            {"szily", "silly"},
            {"jó", "yo"},
            {"a", "ah"},
            {"az", "ahz"},
            {"én", "ane"},
            {"segít", "shegeet"},
            {"srác", "shraatz"},
            {"jófej", "yofey"},
            {"ferenc", "ferentz"},
    };

    @Test
    public void hungarianToEnglish() {
        for (String[] testCase : testCases) {
            assertEquals(testCase[1], HungarianRules.phonetize(testCase[0]));
        }
    }

    @Test
    public void testMakeJsonArray() {
        assertEquals("[\"a\\\"\"]", FonetikApp.makeJsonArray("a\""));
    }
}
