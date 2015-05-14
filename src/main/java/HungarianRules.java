import java.util.Arrays;
import java.util.Locale;

interface HungarianRules {
    String vowels = "aáeéiíoóöőuúüű";
    String consonants = "bcdfghjklmnpqrstvwxyz";

    static String phonetize(String input) {
        return Arrays.stream(input.replaceAll("\n", " ").split("[^" + vowels + vowels.toUpperCase() + consonants + consonants.toUpperCase() + "]+"))
                .map(HungarianRules::phonetizeCaseSensitiveWord)
                .reduce((acc, item) -> acc + " " + item)
                .get()
                ;
    }

    static String phonetizeCaseSensitiveWord(String input) {
        final String lowercaseWord = phonetizeWord(input.toLowerCase(Locale.forLanguageTag("hu")));
        return capitalize(lowercaseWord, input);
    }

    static String capitalize(String lowercaseWord, String input) {
        if (lowercaseWord.length() == 0) {
            return lowercaseWord;
        }
        if (isFirstCharacterUpperCase(input)) {
            return lowercaseWord.substring(0, 1).toUpperCase() + lowercaseWord.substring(1);
        }

        return lowercaseWord;
    }

    static boolean isFirstCharacterUpperCase(String input) {
        if (input.length() > 0) {
            return Character.isUpperCase(input.charAt(0));
        }
        return false;
    }

    static String phonetizeWord(String input) {
        return input
                .replaceAll("j", "y")
                .replaceAll("([" + vowels + "])cs$", "$1tch")
                .replaceAll("cs", "ch")
                .replaceAll("dzs", "j")
                .replaceAll("zsó$", "sow")
                .replaceAll("zs", "s")
                .replaceAll("s([^zs]|$)", "sh$1")
                .replaceAll("ssz", "ss")
                .replaceAll("sz", "s")
                .replaceAll("^v", "w")
                .replaceAll("é", "ay")
                .replaceAll("i", "ee")
                .replaceAll("í", "ee")
                .replaceAll("eeo", "eo")
                .replaceAll("gee", "gi")
                .replaceAll("ó$", "oe")
                .replaceAll("ó", "oa")
                .replaceAll("ö", "oe")
                .replaceAll("ő", "oe")
                .replaceAll("á", "aa")
                .replaceAll("ú", "u")
                .replaceAll("ü", "ue")
                .replaceAll("ű", "u")
                .replaceAll("eely$", "ill_y")
                .replaceAll("ly", "y")
                .replaceAll("ny", "n")
                .replaceAll("c([" + vowels + "])", "ts$1")
                .replaceAll("etee$", "etty")
                .replaceAll("bayor", "baior")
                .replaceAll("haras", "haaras")
                .replaceAll("enejer", "anager")
                .replaceAll("koesee", "kossy")
                .replaceAll("oesoenoe", "oessono")
                .replaceAll("aabo", "ahbo")
                .replaceAll("aysh", "ayesh")
                .replaceAll("tuk", "took")
                .replaceAll("wayg", "vague-")
                .replaceAll("bass", "bahss")
                .replaceAll("aatay", "aatey")
                .replaceAll("aee$", "ai")
                .replaceAll("hh", "h")
                .replaceAll("az", "ahz")
                .replaceAll("vai$", "vaayi")
                .replaceAll("eshte", "ashte")
                .replaceAll("aak$", "aahk")
                .replaceAll("e([" + consonants + "])e$", "e$1eh")
                .replaceAll("falussh", "faloosh")
                .replaceAll("^seel", "syl")
                .replaceAll("wayda", "wai-da")
                .replaceAll("chay$", "chai")
                .replaceAll("yoe$", "yo")
                .replaceAll("^a$", "ah")
                .replaceAll("^ayn$", "ane")
                .replaceAll("shegit", "shegeet")
                .replaceAll("aac$", "aatz")
                .replaceAll("yoasha", "yosha")
                .replaceAll("yoaf", "yof")
                .replaceAll("nc$", "ntz")
                .replaceAll("_", "")
                ;
    }
}
