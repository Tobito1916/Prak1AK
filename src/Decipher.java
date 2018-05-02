import java.util.HashMap;
import java.util.Map;

public class Decipher {

    // Relative Häufigkeit der Buchstaben im Input-Text (Großbuchstaben A-Z)

    public HashMap<Character, Double> relativeFrequency (String input) {
        int total = 1;  //Gesamtanzahl der Buchstaben
        char[] inputArray = input.toCharArray();
        double[] count = new double[26];
        HashMap<Character, Double> countMap = new HashMap<>();

        for ( char c : inputArray ) if ( c <= 90 && c >= 65) total++;
        for (char c : inputArray ) if ( c <= 90 && c >= 65) count[c-65] ++;
        for ( int i = 0; i < 26; i++ ) countMap.put((char)(i + 'A'), (count[i] / total));

        return countMap;
    }


    public Map sortedFrequency (HashMap<Character, Double> frequency) {
        return SortHashMap.sortByValue(frequency);
    }

    public static void main ( String[] args){
        Decipher d = new Decipher();

        HashMap<Character, Double> hmap = d.relativeFrequency("NRW OPYLC NWQ QIMAWOWO SWQYWMY KP WSWO NPCRO, NPQQ QWRO \n" +
                "ROOCWQ VWQWO PLQQWC NWO GCWOXWO NWC NWOJJCPHY, RO QWROWC \n" +
                "WOYQYWMLOG, RO QWROWF WRGOWO VWCNWO URWGY. WSWO NPCLF, \n" +
                "VWRU NRW NWOJJCPHY SWRF QIMAWOWO ORIMY FWMC HCPGWO JPOO,\n" +
                "VPCLF WQ QIMAWO QWR, RQY WQ QIMAWO. NWOO WQ FPOGWUY KP \n" +
                "NWC NWOJJCPHY EAWUURG PO WROWF EWCGUWRIMLOGQDLOJYW, \n" +
                "VA OPIM QRW NPQ QIMAWOW SWLCYWRUWO LON SWYCPIMYWO JAWOOYW. \n" +
                "VPQ GRSY WQ OAIM HLWC WROWO EWCGUWRIMLOGQDLOJY HLWC NPQ \n" +
                "WIMYW QIMAWOW, PUQ FRY NWF ROSWGCRHH PUUWC MPCFAORQIMWO \n" +
                "EWCMPWUYORQQW NWQ GCAQQWO GPOXWO NWC OPYLC, NRW JWROW \n" +
                "NWOJJCPHY LFHPQQWO JPOO. PUUWQ WROXWUOW, MRO LON MWC RO NWC \n" +
                "OPYLC XWCQYCWLYW QIMAWOW RQY KP OLC ROQAHWCO QIMAWO, PUQ QRIM \n" +
                "NRWQWC ROSWGCRHH PUUWC EWCMPWUYORQQW KWOWQ GCAQQWO GPOXWO \n" +
                "FWMC ANWC VWORGWC NPCRO AHHWOSPCY. WQ JPOO PUQA ORW XLF \n" +
                "EWCGUWRIMLOGQDLOJYW HLWC NPQ QIMAWOW NWC SRUNWONWO JLWOQYW, \n" +
                "WSWOQAVWORG PUQ NWC VPMCWO OPIMPMFLOG NWQ QIMAWOWO \n" +
                "XLF EACSRUNW NRWOWO; VWRU NPQ MAWIMQYW QIMAWOW RF WRO- \n" +
                "XWUOWO NWC OPYLC RFFWC OAIM ORIMY QIMAWO GWOLG HLWC NRW \n" +
                "QYAUXW OPIMPMFLOG NWC GCAQQWO LON FPKWQYPWYRQIMWO EWCMPWUYORQQW\n" +
                "NWQ PUULFHPQQWONWO GPOXWO NWC OPYLC RQY. NPQ \n" +
                "QIMAWOW JPOO NPMWC ORIMY WCJPOOY, WQ FLQQ MWCEACGWSCPIMY \n" +
                "ANWC WFDHLONWO VWCNWO. \n" +
                "\n" +
                "NWOO VWRU RO GPWOXURIMWC WCFPOGULOG WROWQ \n" +
                "EWCGUWRIMLOGQDLOJYWQ WROFPU NPQ QIMAWOW JWRO GWGWOQYPON NWC \n" +
                "NWOJJCPHY RQY, QA VLWCNWO VRC, ROQAHWCO VRC WQ ORIMY QWUSQY \n" +
                "MWCEACSCROGWO JAWOOWO, PLIM QWROWQ GWOLQQWQ GPOX WOYSWMCWO \n" +
                "FLWQQWO, RONWF VRC LOQ ORW PO WYVPQ MPUYWO JAWOOYWO, NWF \n" +
                "NPQ QIMAWOW OPWMWC JPWFW PUQ NPQ FRONWCQIMAWOW — VWOO \n" +
                "ORIMY WYVPQ NRW QYWUUW NWC MWCEACSCROGWONWO JCPHY RO LOQ \n" +
                "WCQWYXYW, NPQ RMC QA OPMW VRW FAWGURIM JAWFFY, AMOW NAIM \n" +
                "QRW QWUSQY XL QWRO: — NRWQ RQY OLO, VPQ VRC GWQIMFPIJ ANWC \n" +
                "WFDHRONLOGQHPWMRGJWRY HLWC NPQ QIMAWOW OWOOWO, NRW, VWOO \n" +
                "QRW RO RMCWO GCWOXWO SUWRSY, NWO FPOGWU NWQ MAWMWCO \n" +
                "GWOLQQWQ SWR NWC MWCEACSCRLGLOG NWQ QIMAWOWO NLCIM NRW \n" +
                "LOGWQYAWCYW CLMW NWC QYRUUWO SWYCPIMYLOG WCQWYXWO JPOO. \n" +
                "VWOO OPWFURIM NPQ ACGPO ORIMY HWRO GWOLG GWVWSY RQY, LF \n" +
                "NWF WROQYCAWFWONWO GPOXWO NWC OPYLC QA ERWUW \n" +
                "SWCLWMCLOGQDLOJYW NPCXLSRWYWO, PUQ OAWYRG QRON, LF PUUW RMCW \n" +
                "GCAQQWO EWCMPWUYORQQW EAUUQYPWONRG RF JUWROWO PSXLQDRWGWUO, \n" +
                "LON LOQ OAIM WRO DLOJY XLF EAWUURGWO QIMULQQ NWQ XRCJWUQ \n" +
                "HWMUY, QA JAWOOWO VRC QYPYY NWC SRUNLOGQJCPHY OLC \n" +
                "WFDHRONLOGQHPWMRGJWRY HLWC NPQ QIMAWOW MPSWO: KWNWC EWCQLIM, WQ \n" +
                "PLQQWC LOQ VRWNWC NPCXLQYWUUWO, VLWCNW LOQ FRQQUROGWO LON \n" +
                "LOQ NWQYA LOXLHCRWNWOWC FRY LOQ QWUSWC FPIMWO, KW OPWMWC \n" +
                "LOQWC WFDHRONLOGQEWCFAWGWO HLWC NPQ QIMAWOW PO NPQ LOQ \n" +
                "FPOGWUONW SRUNLOGQEWCFAWGWO GCWOXY. \n" +
                "VWRU OPWFURIM NPQ VWQWO NWQ QIMAWOWO WSWO RO QWROWC \n" +
                "EAUUWONLOG RO QRIM QWUSQY SWQYWMY, QA QIMPNWY RMF NWC UWYXYW \n" +
                "HWMUWONW DLOJY QA ERWU PUQ YPLQWON; NWOO WC EWCCLWIJY PUUW \n" +
                "LWSCRGWO DLOJYW PLQ NWC QYWUUW, RO VWUIMW QRW GWMAWCWO. \n" +
                "LON RQY NRWQWC EAUUWONLOGQDLOJY WROFPU EWCHWMUY, QA EWC- \n" +
                "UAMOY WRO VWCJ NWC JLOQY NWC FLWMW NWQ POHPOGQ LON NWC \n" +
                "XWRY QWROWQ VWCNWOQ ORIMY; WQ HPWUUY LOYWC NPQ QIMUWIMYW \n" +
                "SRQ XLF LOOLWYXWO MWCPS, LON QWRO NPQWRO FLQQ OAYVWONRG \n" +
                "NLCIM NRW EWCGWQQWOMWRY, VACRO WQ QROJY, QRIM VRWNWC \n" +
                "PLHMWSWO. \n" +
                "\n");

        System.out.println(hmap);
        Map sortedHMap = d.sortedFrequency(hmap);
        System.out.println(sortedHMap);
    }


}
