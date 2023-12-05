package year2023.day5

import kotlin.system.exitProcess

val testInput = """
    seeds: 79 14 55 13

    seed-to-soil map:
    50 98 2
    52 50 48

    soil-to-fertilizer map:
    0 15 37
    37 52 2
    39 0 15

    fertilizer-to-water map:
    49 53 8
    0 11 42
    42 0 7
    57 7 4

    water-to-light map:
    88 18 7
    18 25 70

    light-to-temperature map:
    45 77 23
    81 45 19
    68 64 13

    temperature-to-humidity map:
    0 69 1
    1 0 69

    humidity-to-location map:
    60 56 37
    56 93 4
""".trimIndent()

val puzzleInput = """
    seeds: 1347397244 12212989 2916488878 1034516675 2821376423 8776260 2240804122 368941186 824872000 124877531 1597965637 36057332 4091290431 159289722 1875817275 106230212 998513229 159131132 2671581775 4213184

    seed-to-soil map:
    2988689842 4194451945 100515351
    2936009234 3353543976 52680608
    588295233 2638661119 66434163
    3932833115 2936009234 88315480
    3525561241 3331695912 21848064
    1622262003 1969921080 210668061
    2160566101 909457337 162053391
    1832930064 1887384181 82536899
    3625461917 3024324714 307371198
    3547409305 3680043285 78052612
    1915466963 588295233 240773057
    3089205193 3758095897 436356048
    4021148595 3406224584 273818701
    2156240020 2705095282 4326081
    1164190025 2180589141 458071978
    2477360206 829068290 80389047
    2322619492 2709421363 154740714
    654729396 1377923552 509460629
    2557749253 1211672006 166251546
    2724000799 1071510728 140161278

    soil-to-fertilizer map:
    3961802244 3774724750 90737174
    3164426550 3931513861 70563571
    147221566 1279409424 704464
    1394834067 2074132435 40845148
    3795834030 2142537807 47621185
    4083197470 4095560143 199407153
    2722903919 2876212954 93296050
    3467494732 2775293966 100918988
    1809650294 1815421878 66426374
    505665614 275280169 12031240
    2142537807 4002077432 60985377
    1577608496 331482268 177958690
    2590855103 2196397738 132048816
    1942888942 1978207624 24340152
    756722275 120895382 4815243
    3435289775 3899308904 32204957
    1967229094 715059087 147748489
    3955563498 2190158992 6238746
    356096070 125710625 149569544
    2520387506 2704826369 70467597
    517696854 2041922514 32209921
    1755567186 0 54083108
    348569226 1280113888 7526844
    761537518 1597328127 34415327
    1114796271 1631743454 128592301
    0 1494456232 102871895
    1070625412 287311409 44170859
    549906775 1287640732 206815500
    102871895 710084154 4974933
    1298474695 1881848252 96359372
    3843455215 2549697361 112108283
    3761987050 3865461924 33846980
    4052539418 2674168317 30658052
    1435679215 862807576 141929281
    795952845 1004736857 274672567
    3729489716 4063062809 32497334
    2203523184 3085216895 316864322
    2931907860 3402081217 11267883
    107846828 2002547776 39374738
    2816199969 2969509004 115707891
    3568413720 3413349100 161075996
    2943175743 2328446554 221250807
    3234990121 3574425096 200299654
    4282604623 2661805644 12362673
    147926030 509440958 200643196
    1876076668 54083108 66812274
    1243388572 1760335755 55086123

    fertilizer-to-water map:
    2460553918 850437816 63304366
    1259757436 1986466040 193004355
    2879827793 2638634287 61837387
    39629536 0 3143529
    2160922553 2535779758 68016930
    2523858284 922523353 36811379
    52449107 1199799263 207670511
    2692884203 2603796688 34837599
    3755186617 147251641 492169035
    3266515480 3620937477 292130997
    1596851845 4077877285 217090011
    2727721802 913742182 8781171
    3055087322 3913068474 164808811
    2228939483 2179470395 229525704
    3668162112 1052896909 87024505
    3219896133 1539684314 30399976
    1510550909 1679599925 86300936
    0 3143529 39629536
    2560669663 1407469774 132214540
    1452761791 1142010145 57789118
    260119618 2700471674 920465803
    3250296109 1036677538 16219371
    1813941856 1026924408 9753130
    4247355652 2488168114 47611644
    1823694986 959334732 67589676
    2831305507 639420676 48522286
    2736502973 52449107 94802534
    1180585421 2408996099 79172015
    2941665180 1765900861 113422142
    2458465187 1139921414 2088731
    3558646477 1570084290 109515635
    1891284662 687942962 162494854
    2053779516 1879323003 107143037

    water-to-light map:
    2196302869 3170532562 121192468
    3065704582 2916528129 254004433
    2858667310 1154274853 9085577
    3789349818 1163360430 70779786
    2064226029 1434838179 90165206
    1448515654 725716988 103420445
    2690533041 2124509945 168134269
    347894075 3345882022 38285799
    3966625235 2618593488 35838159
    4186823059 4134088017 89981817
    1701108140 1088713231 65561622
    2589948930 2518009377 100584111
    4283393470 4230658428 11573826
    0 3384167821 347894075
    1638541363 2061943168 62566777
    1296314418 573515752 152201236
    1065865126 194284013 230449292
    1766669762 1991838394 70104774
    830054797 2292644214 110248534
    3595088014 3291725030 12245358
    1978385607 1905997972 85840422
    3607333372 424733305 148782447
    3511869770 2833309885 83218244
    4134088017 4242232254 52735042
    2154391235 3303970388 41911634
    494720868 3732061896 335333929
    1836774536 1234140216 141611071
    2317495337 1633544379 272453593
    4002463394 2402892748 64932431
    940303331 829137433 125561795
    1551936099 954699228 27518372
    4276804876 4224069834 6588594
    3756115819 2467825179 33233999
    2867752887 0 19073457
    386179874 1525003385 108540994
    1579454471 1375751287 59086892
    3319709015 2501059178 16950199
    3336659214 19073457 175210556
    3860129604 982217600 106495631
    2886826344 2654431647 178878238

    light-to-temperature map:
    977891457 1797846421 453265654
    3607226990 3913974738 161345346
    2303244644 3266224873 12707372
    1537599301 3278932245 264559714
    354466514 3168465761 62294113
    747844586 3543491959 55668994
    2982698313 3599160953 269886589
    2067998119 2251112075 27763866
    59336731 230685734 266868096
    3768572336 1500157846 31849471
    3856743875 939537646 438223421
    2095761985 59336731 146190926
    326204827 4075320084 28261687
    1502134302 3230759874 35464999
    1431157111 868560455 70977191
    2315952016 2579115195 227102616
    1802159015 1532007317 265839104
    2241952911 807268722 61291733
    3297512098 497553830 309714892
    852851251 4103581771 2643427
    3252584902 3869047542 44927196
    855494678 1377761067 122396779
    2543054632 4106225198 139404427
    2682459059 2278875941 300239254
    803513580 4245629625 49337671
    416760627 205527657 25158077
    3800421807 2806217811 56322068
    441918704 2862539879 305925882

    temperature-to-humidity map:
    3507573 490548898 11693081
    545755853 699222305 569882925
    3794976513 167435410 77260251
    0 1526297837 3507573
    1335234764 1766508370 36536350
    2131780538 502241979 64264976
    3707588652 1679120509 87387861
    96082543 2288930706 220305732
    1371771114 1529805410 106547120
    481810045 3044354609 63945808
    15200654 1426594789 7560739
    3206337878 109359655 58075755
    2445677382 2019348918 269581788
    1909096745 3571407035 4209780
    3138678479 4049712539 66833109
    3400069156 3490205314 81201721
    4084645800 3846924477 65868498
    2353535073 1434155528 92142309
    1716598669 3935506457 114206082
    3264413633 4116545648 30901597
    1913306525 3628450464 218474013
    3205511588 3461720938 826290
    2748703371 2770603565 195642711
    2715259170 244990096 33149766
    1478318234 3108300417 88629505
    22761393 0 73321150
    3295315230 3575616815 45887125
    3872236764 278139862 212409036
    2196045514 1269105230 157489559
    2972004168 2509236438 123906332
    316388275 3296299168 165421770
    1685215763 3025113077 18894296
    2748408936 244695661 294435
    3704521599 4147447245 3067053
    1215008024 566506955 120226740
    1830804751 3912792975 22713482
    1704110059 686733695 12488610
    3488217401 1803044720 216304198
    1872711004 3044007373 347236
    1566947739 2652335541 118268024
    3481270877 3621503940 6946524
    2944346082 3462547228 27658086
    3095910500 1636352530 42767979
    1115638778 3196929922 99369246
    3341202355 2966246276 58866801
    1853518233 2633142770 19192771
    1873058240 73321150 36038505

    humidity-to-location map:
    336906655 0 11018487
    4177510177 2085057023 105144397
    1299579245 2985741466 175347598
    643133711 2270603056 161424888
    2404489601 1000033728 105953201
    4282654574 2864154964 12312722
    3409171342 3327025690 30826088
    2119751049 2190201420 80401636
    3393269098 3357851778 15902244
    82121354 319849190 39107402
    1953814423 3161089064 165936626
    64524116 385149760 17597238
    3439997430 2057119912 27937111
    0 358956592 26193168
    347925142 11018487 93152804
    1484466972 2432027944 360604841
    2510442802 643133711 347359888
    26193168 402746998 38330948
    1190305465 2946259551 39481915
    2200152685 1105986929 204336916
    3467934541 2792632785 71522179
    804558599 3373754022 385746866
    3539456720 1310323845 638053457
    2857802690 3759500888 535466408
    121228756 104171291 215677899
    1229787380 2876467686 69791865
    1474926843 990493599 9540129
    1845071813 1948377302 108742610
""".trimIndent()

class Mapping(val from: String, val to: String) {
    private val changes = mutableMapOf<LongRange, (Long) -> Long>()

    fun addMapping(destinationRangeStart: Long, sourceRangeStart: Long, rangeLength: Long) {
        // I'm assuming there's no re-mapping going on
        if (changes[LongRange(sourceRangeStart, sourceRangeStart + (rangeLength - 1))] != null) {
            println("Range already exists in map, this is rather unexpected.")
            exitProcess(1)
        }

        val difference = if (sourceRangeStart > destinationRangeStart) {
            -(sourceRangeStart - destinationRangeStart)
        } else {
            destinationRangeStart - sourceRangeStart
        }

        changes[LongRange(sourceRangeStart, sourceRangeStart + (rangeLength - 1))] =
            { value -> value + difference}
    }

    fun lookup(place: Long): Long {
        val rangeContainingValue = changes.keys.singleOrNull { it.contains(place) }

        if (rangeContainingValue != null) {
            return changes[rangeContainingValue]!!.invoke(place)
        }

        return place
    }

    override fun toString(): String {
        return "Map[$from -> $to]"
    }
}

fun part1(seeds: List<Long>, mappings: List<Mapping>) {
    var valueToLookup = 0L
    val locations = mutableListOf<Long>()
    for (seed in seeds) {
        print("Seed $seed -> ")
        valueToLookup = seed
        for (mapping in mappings) {
            print("${mapping.to} ${mapping.lookup(valueToLookup)} -> ")
            valueToLookup = mapping.lookup(valueToLookup)
            if (mapping.to == "location") {
                locations.add(valueToLookup)
            }
        }
        println()
    }

    println("Locations are: ${locations.sorted()}")
}

fun part2(seeds: List<Long>, mappings: List<Mapping>) {
    var valueToLookup = 0L
    var locations = Long.MAX_VALUE
    val seedRanges = mutableListOf<LongRange>()

    seeds.chunked(2).forEach {
        seedRanges.add(LongRange(it[0], it[0] + (it[1] - 1)))
    }
    for ((idx, seedRange) in seedRanges.withIndex()) {
        for (seed in seedRange.first..seedRange.last) {
//            print("Seed $seed -> ")
            valueToLookup = seed
            for (mapping in mappings) {
//                print("${mapping.to} ${mapping.lookup(valueToLookup)} -> ")
                valueToLookup = mapping.lookup(valueToLookup)
                if (mapping.to == "location") {
                    locations = locations.coerceAtMost(valueToLookup)
                }
            }
//            println()
        }
    }

    println("lowest location is: $locations")
}


fun main(args: Array<String>) {
    val lines = puzzleInput.lines()
    val seeds = lines[0].split(":")[1].trim().split(" ")
        .filter { it.isNotEmpty() }
        .map { it.toLong() }

    println("seeds are $seeds")

    val regex = Regex("([a-z]+)-to-([a-z]+) map:")
    val mappingList = mutableListOf<Mapping>()
    var currentMapping = Mapping("temp", "temp")

    for (line in puzzleInput.lines()) {
        if (line.isEmpty() || line.startsWith("seeds: ")) {
            continue
        }

        val match = regex.find(line)
        if (match?.groups?.isNotEmpty() == true) {
//            println("Parsing ${match.groupValues[1]} to ${match.groupValues[2]}")
            currentMapping = Mapping(match.groupValues[1], match.groupValues[2])
            mappingList.add(currentMapping)
            continue
        }
        val lineValues = line.split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toLong() }

//        println("Adding $lineValues to $currentMapping")
        currentMapping.addMapping(lineValues[0], lineValues[1], lineValues[2])
    }
    part2(seeds, mappingList)
}
