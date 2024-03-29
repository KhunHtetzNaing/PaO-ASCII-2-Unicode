package com.htetznaing.test

import org.jetbrains.annotations.TestOnly
import org.json.JSONArray
import org.json.JSONObject

/**
 * ASCII စနစ်ဖြင့်ရေးထားသောပအိုဝ်းစာများကို Unicode စံစနစ်ကိုက်ညီသောစာများအဖြစ်ပြောင်းပေးနိုင်ရန်ဖြစ်သည်။
 */
class AM2{
        private val am2UnicodeRules = mapOf(
            "\u0031\u2044\u0032" to "\u101b", // 1/2 => ရ
            "\u0033\u2044\u0034" to "\u1039\u1002", // 3/4 => ္ဂ
            "\u005D\u005D" to "\u201C", // ]] => “
            "\u007D\u007D" to "\u201D", // }} => ”
            "\u0020\u0308" to "\u1039\u1013", // }} => ”
            "\u0031\u0065" to "\u100D\u1039\u100E\u1014", // 1e => ဍ္ဎန
            "\u0074\u0020\u0048" to "\u1021\u1036", // t H => အံ
            "\u0061" to "\u1031", // a => ေ
            "\u0062" to "\u1018", // b => ဘ
            "\u0063" to "\u1001", // c => ခ
            "\u0064" to "\u102d", // d => ိ
            "\u0065" to "\u1014", // e => န
            "\u0066" to "\u103a", // f => ်
            "\u0067" to "\u102b", // g => ါ
            "\u0068" to "\u1037", // h => ့
            "\u0069" to "\u1004", // i => င
            "\u006a" to "\u103c", // j => ြ
            "\u006b" to "\u102f", // k => ု
            "\u006c" to "\u1030", // l => ူ
            "\u006d" to "\u102c", // m => ာ
            "\u006e" to "\u100a", // n => ည
            "\u006f" to "\u101e", // o => သ
            "\u0070" to "\u1005", // p => စ
            "\u0071" to "\u1006", // q => ဆ
            "\u0072" to "\u1019", // r => မ
            "\u0073" to "\u103b", // s => ျ
            "\u0074" to "\u1021", // t => အ
            "\u0075" to "\u1000", // u => က
            "\u0076" to "\u101c", // v => လ
            "\u0077" to "\u1010", // w => တ
            "\u0078" to "\u1011", // x => ထ
            "\u0079" to "\u1015", // y => ပ
            "\u007a" to "\u1016", // z => ဖ
            "\u0030" to "\u1040", // 0 => ၀
            "\u0031" to "\u1041", // 1 => ၁
            "\u0032" to "\u1042", // 2 => ၂
            "\u0033" to "\u1043", // 3 => ၃
            "\u0034" to "\u1044", // 4 => ၄
            "\u0035" to "\u1045", // 5 => ၅
            "\u0036" to "\u1046", // 6 => ၆
            "\u0037" to "\u1047", // 7 => ၇
            "\u0038" to "\u1048", // 8 => ၈
            "\u0039" to "\u1049", // 9 => ၉
            "\u0021" to "\u100d", // ! => ဍ
            "\u0022" to "\u1013", // " => ဓ
            "\u0023" to "\u100b", // # => ဋ
            "\u0024" to "\u103c\u103d", // $ => ြွ
            "\u0026" to "\u101b", // & => ရ
            "\u0027" to "\u1012", // ' => ဒ
            "\u002a" to "\u1002", // * => ဂ
            "\u002c" to "\u101a", // , => ယ
            "\u002e" to "\u108f", // . => ႏ
            "\u002f" to "\u104b", // / => ။
            "\u003a" to "\u102b\u103a", // : => ါ်
            "\u003b" to "\u1038", // ; => း
            "\u003c" to "\u103c\u103d", // < => ြွ
            "\u003e" to "\uaa7b", // > => ꩻ
            "\u003f" to "\u104a", // ? => ၊
            "\u0040" to "\u100f\u1039\u100d", // @ => ဏ္ဍ
            "\u0041" to "\u1017", // A => ဗ
            "\u0042" to "\u103c", // B => ြ
            "\u0043" to "\u1003", // C => ဃ
            "\u0044" to "\u102e", // D => ီ
            "\u0045" to "\u1014", // E => န
            "\u0046" to "\u1004\u103a\u1039", // F => င်္
            "\u0047" to "\u103d", // G => ွ
            "\u0048" to "\u1036", // H => ံ
            "\u0049" to "\u103e\u102f", // I => ှု
            "\u004a" to "\u1032", // J => ဲ
            "\u004b" to "\u102f", // K => ု
            "\u004c" to "\u1030", // L => ူ
            "\u004d" to "\u103c", // M => ြ
            "\u004e" to "\u103c", // N => ြ
            "\u004f" to "\u1025", // O => ဥ
            "\u0050" to "\u100f", // P => ဏ
            "\u0051" to "\u103b\u103e", // Q => ျှ
            "\u0052" to "\u103b\u103d", // R => ျွ
            "\u0053" to "\u103e", // S => ှ
            "\u0054" to "\u103d\u103e", // T => ွှ
            "\u0055" to "\u1037", // U => ့
            "\u0056" to "\u1020", // V => ဠ
            "\u0057" to "\u103b\u103d\u103e", // W => ျွှ
            "\u0058" to "\u100c", // X => ဌ
            "\u0059" to "\u1037", // Y => ့
            "\u005a" to "\u1007", // Z => ဇ
            "\u005b" to "\u101f", // [ => ဟ
            "\u005c" to "\u104f", // \ => ၏
            "\u005d" to "\u2018", // ] => ‘
            "\u005e" to "\u002f", // ^ => /
            "\u0060" to "\u103c", // ` => ြ
            "\u005f" to "\u0078", // _ => x
            "\u007b" to "\u1027", // { => ဧ
            "\u007c" to "\u100b\u1039\u100c", // | => ဋ္ဌ
            "\u007d" to "\u0027", // } => '
            "\u007e" to "\u103c", // ~ => ြ
            "\u00a1" to "\u100e", // ¡ => ဎ
            "\u00a2" to "\u1039\u1003", // ¢ => ္ဃ
            "\u00a3" to "\u1023", // £ => ဣ
            "\u00a4" to "\u104e", // ¤ => ၎
            "\u00a5" to "\u100b\u1039\u100b", // ¥ => ဋ္ဋ
            "\u00a6" to "\u1039\u1011", // ¦ => ္ထ
            "\u00a7" to "\u103e", // § => ှ
            "\u00a8" to "\u1039\u1013", // ¨ => ္ဓ
            "\u00a9" to "\u1039\u1001", // © => ္ခ
            "\u00aa" to "\u103e\u1030", // ª => ှူ
            "\u00ab" to "\u005b", // « => [
            "\u00ac" to "\u1039\u1011", // ¬ => ္ထ
            "\u00ae" to "\u1039\u1019", // ® => ္မ
            "\u00b0" to "\u1019\u1039\u1015", // ° => မ္ပ
            "\u00b1" to "\u1017\u1039\u1018", // ± => ဗ္ဘ
            "\u00b2" to "\u1039\u100c", // ² => ္ဌ
            "\u00b3" to "\u1039\u100b", // ³ => ္ဋ
            "\u00b4" to "\u1039\u1012", // ´ => ္ဒ
            "\u00B5" to "\u00A7", // µ => §
//            "\u00b6" to "\u100f\u1039\u100f", // ¶ => ဏ္ဏ
            "\u00b6" to "\u108F", // ¶ => ႏ
            "\u00b8" to "\u1014\u1039\u1014", // ¸ => န္န
            "\u00b9" to "\u100d\u1039\u100e", // ¹ => ဍ္ဎ
            "\u00ba" to "\u100f\u1039\u100c", // º => ဏ္ဌ
            "\u00bb" to "\u005d", // » => ]
            "\u00bc" to "\u100b", // ¼ => ဋ
            "\u00bd" to "\u101b", // ½ => ရ
            "\u00be" to "\u1039\u1002", // ¾ => ္ဂ
            "\u00bf" to "\u003f", // ¿ => ?
            "\u00c0" to "\u2666", // À => ♦
            "\u00c1" to "\u1039\u1017", // Á => ္ဗ
            "\u00c2" to "\u2713", // Â => ✓
            "\u00c3" to "\u2663", // Ã => ♣
            "\u00c4" to "\u002a", // Ä => *
            "\u00c5" to "\u1039\u1010", // Å => ္တ
            "\u00c6" to "\u1039\u1007", // Æ => ္ဇ
            "\u00c7" to "\u1039\u1018", // Ç => ္ဘ
            "\u00c8" to "\u1014\u1039\u1013", // È => န္ဓ
            "\u00c9" to "\u1014\u1039\u1010\u103d", // É => န္တွ
            "\u00ca" to "\u201c", // Ê => “
            "\u00cb" to "\u100f\u1039\u100d", // Ë => ဏ္ဍ
            "\u00cc" to "\u100f\u1039\u100b", // Ì => ဏ္ဋ
            "\u00cd" to "\u1009", // Í => ဉ
            "\u00ce" to "\u103c\u103e", // Î => ြှ
            "\u00cf" to "\u1014\u1039\u1012\u103c", // Ï => န္ဒြ
            "\u00d0" to "\u1004\u103a\u1039\u102e", // Ð => င်္ီ
            "\u00d1" to "\u1039\u1005\u103b", // Ñ => ္စျ
            "\u00d2" to "\u101c\u1039\u101c", // Ò => လ္လ
            "\u00d3" to "\u1009\u102c", // Ó => ဉာ
            "\u00d4" to "\u103b\u103d", // Ô => ျွ
            "\u00d5" to "\u1009\u1039\u1005", // Õ => ဉ္စ
            "\u00d6" to "\u1039\u100f", // Ö => ္ဏ
            "\u00d7" to "\u100d\u1039\u100d", // × => ဍ္ဍ
            "\u00d8" to "\u1004\u103a\u1039\u102d", // Ø => င်္ိ
            "\u00d9" to "\u1009\u1039\u1007", // Ù => ဉ္ဇ
            "\u00da" to "\u1009", // Ú => ဉ
            "\u00db" to "\u1010\u1039\u1011", // Û => တ္ထ
            "\u00dc" to "\u1039\u1015", // Ü => ္ပ
            "\u00dd" to "\u1015\u1039\u1015", // Ý => ပ္ပ
            "\u00de" to "\u1010\u1039\u1010", // Þ => တ္တ
            "\u00df" to "\u103b", // ß => ျ
            "\u00e0" to "\u1017\u1039\u1017", // à => ဗ္ဗ
            "\u00e1" to "\u25ba", // á => ►
            "\u00e2" to "\u0078", // â => x
            "\u00e3" to "\u1019\u103c\u102d\u102f\u1037", // ã => မြို့
            "\u00e4" to "\u1039\u1006", // ä => ္ဆ
            "\u00e5" to "\u1039\u1010", // å => ္တ
            "\u00e6" to "\u1039\u1016", // æ => ္ဖ

            "\u00e7" to "\u002c", // ç => ,
            "\u00e7" to "\uAA7B", // ç => ꩻ

            "\u00e8" to "\u005f", // è => _
            "\u00e9" to "\u1039\u1014", // é => ္န
            "\u00ea" to "\u103c\u102f", // ê => ြု
            "\u00eb" to "\u1032", // ë => ဲ
            "\u00ec" to "\u1009\u103e", // ì => ဉှ
            "\u00ed" to "\u104d", // í => ၍
            "\u00ee" to "\u1009\u103e", // î => ဉှ
            "\u00ef" to "\u1020\u103e", // ï => ဠှ
            "\u00f0" to "\u102d\u1036", // ð => ိံ
            "\u00f1" to "\u100a", // ñ => ည
            "\u00f2" to "\u1012\u1039\u1013", // ò => ဒ္ဓ
            "\u00f3" to "\u103f", // ó => ဿ
            "\u00f4" to "\u1012\u1039\u1012", // ô => ဒ္ဒ
            "\u00f5" to "\u1005\u1039\u1005", // õ => စ္စ
            "\u00f6" to "\u1039\u1005", // ö => ္စ
            "\u00f7" to "\u00f7", // ÷ => ÷
            "\u00f8" to "\u1004\u103a\u1039\u1036", // ø => င်္ံ
            "\u00f9" to "\u1014\u1039\u1012", // ù => န္ဒ
            "\u00fa" to "\u1039\u1000", // ú => ္က
            "\u00fb" to "\u103c\u102f", // û => ြု
            "\u00fc" to "\u104c", // ü => ၌
            "\u00fd" to "\u1014\u1039\u1007", // ý => န္ဇ
            "\u00fe" to "\u1024", // þ => ဤ
            "\u00ff" to "\u1019\u1039\u1019", // ÿ => မ္မ
            "\u0152" to "\u2606", // Œ => ☆
            "\u0153" to "\u002e\u002e\u002e", // œ => ...
            "\u0160" to "\u1039\u1018", // Š => ္ဘ
            "\u0161" to "\u1039\u1010", // š => ္တ
            "\u0178" to "\u1039\u1015", // Ÿ => ္ပ
            "\u0192" to "\u104d", // ƒ => ၍
            "\u02c6" to "\u2605", // ˆ => ★
            "\u00af" to "\u1026", // ¯ => ဦ
            "\u02dc" to "\u2605", // ˜ => ★
            "\u2014" to "\u2713", // — => ✓
            "\u2018" to "\u1007\u1039\u1007", // ‘ => ဇ္ဇ
            "\u2019" to "\u1000\u1039\u1001", // ’ => က္ခ
            "\u201a" to "\u005f", // ‚ => _
//            "\u201c" to "\u1005\u1039\u1006", // “ => စ္ဆ
//            "\u201d" to "\u003e\u003e", // ” => >>
            "\u201e" to "\u2713", // „ => ✓
            "\u2020" to "\u1000\u1039\u1000", // † => က္က
            "\u2021" to "\u1002\u1039\u1003", // ‡ => ဂ္ဃ
            "\u2026" to "\u1039\u1017", // … => ္ဗ
            "\u2030" to "\u1014\u1039\u1012", // ‰ => န္ဒ
            "\u2039" to "\u100f\u1039\u100b", // ‹ => ဏ္ဋ
            "\u203a" to "\u1014\u1039\u1010", // › => န္တ
            "\u2122" to "\u1009\u1039\u1005", // ™ => ဉ္စ
            "\u2212" to "\u1014\u1039\u1010", // − => န္တ
            "\u00b7" to "\u108f", // · => ႏ
            "\u2666" to "\u1014\u1039\u1010\u103d", // ♦ => န္တွ
            "\u266a" to "\u1026", // ♪ => ဦ
            "\u266b" to "\u2605", // ♫ => ★
            "\ufb02" to "\u0021", // ﬂ => !,
            "\u0020\u0301" to "\u1039\u1012", //  ́ => ္ဒ,
        )

        private val reorderUnicodeRules = mapOf(

            // သေးသေးတင်
            "(ံ)(ု)?(ူ)?" to "$2$3$1",

            // လုံးကြီးတင် ဝဆွဲ
            "(ိ|ီ)(ွ)" to "$2$1",

            // နှစ်ခါရေးမိသောစာလုံးများထည့်ရန် ဥပမာ ဝဆွဲနှစ်ခါ

            // ရရစ်
            // နံပါတ် ၇ -> ရကောက်
            "(ြ)(၇)" to "ြရ",
            // သုည -> ဝလုံး
            "(ြ)(၀)" to "ြဝ",

            "(ြ)([က-အ])" to "$2$1",
            "(ြ)(ွ)([က-အ])" to "$3$1$2",

            // အသတ်
            "([က-အဿ])(င်္)" to "$2$1",

            // တစ်ချောင်းငင်
            "(ု)?(ူ)?(ိ)?(ီ)?" to "$3$4$1$2",

            // နောက်ပစ်
            "(ဲ)?(ူ)?(ု)?(ျ)?(ြ)?" to "$2$3$4$5$1",

            // သုည -> ဝလုံး
            "၀(ိ|ီ|ု|ူ|ံ|့|ှ|်|း|ါ|ာ|[က-အ]်|ျ|ဲ|ႏ|ꩻ|ွ)" to "ဝ$1",
            "၇(ိ|ီ|ု|ူ|ံ|့|ှ|်|း|ါ|ာ|[က-အ]်|ျ|ဲ|ႏ|ꩻ|ွ)" to "ရ$1",

            // သဝေထိုး
            // နံပါတ် ၇ -> ရကောက်
            "(ေ)(၇)" to "ေရ",
            // သုည -> ဝလုံး
            "(ေ)(၀)" to "ေဝ",

            "(ေ)(ြ)?([က-အဿ])(ြ)?(ွ)?(ျ)?(ွ)?(ု)?(ှ)?" to "$3$2$4$6$5$7$1$8$9",

            // သဝေထိုး + စာလုံးဆင့်
            "([က-အ])(ေ)(္[က-အ])" to "$1$3$2",
        )

    private fun transform(am2: String): String {
        var data = am2
        am2UnicodeRules.forEach {
            val from = it.key
            val to = it.value
            data = data.replace(from,to)
        }
        return data
    }

    private fun reorderUnicode(input: String): String {
        var out = input
        reorderUnicodeRules.forEach {
            out = out.replace(it.key.toRegex(),it.value)
        }
        return out
    }

    fun convert(am2Text: String): String {
        val data = transform(am2Text)
        return reorderUnicode(data)
    }

    fun toDart(){
        println(
            "class AM2 {\n" +
                    "  final am2UnicodeRules = ${toJSON(am2UnicodeRules).replace("$","\\$")};\n" +
                    "\n" +
                    "  final reorderUnicodeRules = ${toJSON(reorderUnicodeRules).replace("$","#")};\n" +
                    "\n" +
                    "  String transform(String am2) {\n" +
                    "    for (var item in am2UnicodeRules) {\n" +
                    "      final from = item[\"from\"]!;\n" +
                    "      final to = item[\"to\"]!;\n" +
                    "      am2 = am2.replaceAll(from, to);\n" +
                    "    }\n" +
                    "    return am2;\n" +
                    "  }\n" +
                    "\n" +
                    "  String reorderUnicode(String input) {\n" +
                    "    for (var item in reorderUnicodeRules) {\n" +
                    "      final from = item[\"from\"]!;\n" +
                    "      final to = item[\"to\"]!;\n" +
                    "      input = input.replaceAllMapped(RegExp(from), (match1) {\n" +
                    "        return to.replaceAllMapped(RegExp(r\"#(\\d)\"), (match2) {\n" +
                    "          final index = match2.group(1);\n" +
                    "          var t = index != null ? match1.group(int.parse(index)) : null;\n" +
                    "          return t ?? \"\";\n" +
                    "        });\n" +
                    "      });\n" +
                    "    }\n" +
                    "    return input;\n" +
                    "  }\n" +
                    "\n" +
                    "  String convert(String am2Text) {\n" +
                    "    final data = transform(am2Text);\n" +
                    "    return reorderUnicode(data);\n" +
                    "  }\n" +
                    "}\n"
        )
    }

    fun toJs(){
        println(
            "const am2unicode_rules = ${toJSON(am2UnicodeRules)};\n" +
                    "const fix_unicode_rules = ${toJSON(reorderUnicodeRules)};\n" +
                    "\n" +
                    "function transform(am2) {\n" +
                    "    var max_loop = am2unicode_rules.length;\n" +
                    "    for (i = 0; i < max_loop; i++) {\n" +
                    "        var data = am2unicode_rules[i];\n" +
                    "        var from = data[\"from\"];\n" +
                    "        var to = data[\"to\"];\n" +
                    "        am2 = am2.replaceAll(from, to);\n" +
                    "    }\n" +
                    "    return am2;\n" +
                    "}\n" +
                    "\n" +
                    "function reorderUnicode(unicode) {\n" +
                    "    var max_loop = fix_unicode_rules.length;\n" +
                    "    for (i = 0; i < max_loop; i++) {\n" +
                    "        var data = fix_unicode_rules[i];\n" +
                    "        var from = data[\"from\"];\n" +
                    "        var to = data[\"to\"];\n" +
                    "\n" +
                    "        var from_regex = new RegExp(from, \"g\");\n" +
                    "        unicode = unicode.replace(from_regex, to);\n" +
                    "    }\n" +
                    "    return unicode;\n" +
                    "}\n" +
                    "\n" +
                    "function convert(am2) {\n" +
                    "    var uni = transform(am2);\n" +
                    "    return reorderUnicode(uni);\n" +
                    "}"
        )
    }

    @TestOnly
    private fun toJSON(rules: Map<String, String>): String {
        val array = JSONArray()
        rules.forEach {
            array.put(JSONObject().apply {
                put("from",it.key)
                put("to",it.value)
            })
        }
        return array.toString(1)
    }
}

fun main() {
    AM2().toDart()
}