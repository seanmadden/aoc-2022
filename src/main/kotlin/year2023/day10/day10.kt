package year2023.day10

import Direction

val testInput = """
    -L|F7
    7S-7|
    L|7||
    -L-J|
    L|-JF
""".trimIndent()

val puzzleInput = """
    L777FJF77F-77-F-7F7.FF.J7.-J--J7F|7F.FJ.L-|F|-F|FJ7-J7F-JFF-7.L7FL7J-FF|7--7.L--|77.F-J77.-7FJ7F7FF--.FFJ7-7-F|.FL-L-F7.F|-FF7F|-7-|7-.FF-7.
    L--77-FJL|7L77.FJ-F-7.|.FJJJ.FFF|FF-77|-|FJ-FJ|LFJ|-L-JLLF|L77|F7L7-|JL-J7LLF7|FLL--7J.-F-|-L-7JF7J7FJ-F-77|.FLJFJ7LJL|7.L7LL7FJFJ|LJLFFJJ|7
    .|L|LFJ7-J-J||-7JLL-J---JL7F7L-LF7L7L77JF7L7--J7F7|.F7LF.L|-|FLJ|L|F|FFJJLJFFJ-7||LF7J7FJF-7.L7L|LFJ7LL|7JFJF|.|||F7JJ|L-7|J7LJ.F7--7L7J7FJ-
    F7J|.L-J-L7F7JFJ.7LJ|-J...L|-|L|||FJFJ..L-FJLL77LLJ7L77J|-7J|F--7-JFL7|F7FFJLJJFJ77L-7-L7F.|J.|F|.L-|7..|FL-FJF-7-LJFL|-L|L|-|F7LL7LL.|FF||.
    J|-L7J.|||L.F.FJ.|7LF.|FF.LL7|LFJ||FJ|.7.L7|FLF7-L.-JL7.F7J-LJJ7L|FJ||J---JF7JLJLL-7.LFJJJL7LF7JJFFF-777FF7|||L-JF|--7JLFL7.FFFF7|L77.|.JL-7
    J7F7|.F-|7-FJ7L-7JF..J.|J7|LL-|L7LJL-7--7JJLFJ|L7F7.FJ77|LJL7FLFFF7L7J-7-|LLJ.|||.LJ7LF.LF||-||FFF-JFJ-J7L-.77-J7F|LJF-F-7L-FF7LF||.F7J..7.7
    LF.L|-J7LJ-7.F|J.FL7-LF7F7L-J.77L-7F-J7.FF7F|FF7L-|77FJ-JFF.|7FF7||-|7LJ.-FL-.L-FJ77|7..LF7|7||FFJF-JL|FJLLF.F7|FJL7FJLLL-L-||.FJ||7|.FF-J7|
    L|7L|7F-J.J|FFF-FJ-7JFLJ|.FJ|.F---JL--7J.LJ-J7.F7J|L77J7.FF.LFFJ|||7F77L|7|FF-J..|||----F7F--JL7L7|.|FL-J.FJ-|FL77FJ|J.F-FJJL-JLLF|77F7L-.LF
    7---LF7|.FL7JL|F7L-L-7FL|7F7.FL7F7F---J.7-7..LL-JFLJF-77F7F7|FL7LJ|F||J7L-F-7-L.FFF7..FFJ||F-7FJF||.L7.|-F|.F7LJ|FJ7|J.|.-77F-J-L|JLF-J7LF..
    LJ7.FLJL--7L7||-|7LF|7J7F-J|F7|LJ|L-7|LFL--7..|JL7LFL7L7|||L7F-JF-JFJ|.F7FJ7LJFL7FJ|F7FJFJLJJ||F-J|77LFFJF-L|L7|LJ7-7-FJLLL7-7F7F-.||7F7FJ7.
    LLF-LF-7||JFL-LLF777F--FL7FJ|L-7F|F7L7-JJ7.L-F7.FF7-|L7||||FJL-7|F7|FJF7|||FJF77FL7|||L7|L|F7|||F7|F7-JJ7J77|.L-7J|7LFJ..FL-7|7||F-7-7-LJJ-7
    |-|.F-7L7|JFJ.|J||LF7F7JFJ|LL-7L-J|L-J.LF77.L||.FJL7F-JLJLJL7F-J||LJL-JL7J7J7F7-FFJ||L-JL7FJLJ|||LJ||7F|FJ|-FJ.F--J7FL-FF-7|LJF-7J.LL|J.|7.7
    J7|F7-L.FF-..F7F|L7||-||L7L--7L--7L7F7F7||-F7||-L-7|L--7F---JL7FJ|F-----JF7F-J|F7L7||F---JL--7|||7FJL--7.7|7L.FFL--F7.F-F-J7J-7FJF-7JJL|L|FL
    .-JLJ.|7||JFF||FJFJ||7|-FJF--JF--JFJ||||||.|LJL77FJL7F-JL--7F-JL-JL----7J||L7FJ|L-JLJL7F7J.F7|LJ|FJF---JFF|7.FFF7F-JJFJ7|LF-7-|JJ7...FFJ7JFL
    7FJ.L-J7JL7FL||L7L7|L7F-JFJLF7L--7L7|||||L7L7F-JFJF-JL----7|L-7F--7F---JFJL7|L7L--7F-7|||7FJLJF-J|FJF-7-||F77F-J|7..FJ|F|.JL7-L7L|L--F|J-F-J
    -7-FJFL.JF7-FJL7L7LJFJL-7L-7|L7F-JFJ|||||FJ|||.FJFJLF7F-7FJL7FJL-7LJ|F7-L-7||FJF-7LJFJLJL7|F-7|F7||FJFJF77||-L7FJ7-F7-F||F|LJ7FJ.--L-LF.LJ7|
    ||.F7J|FLJ||L-7|LL-7L7F7|F-J|FJL-7|FJ||LJ|JFJ|FJFJF7|LJFJL-7LJF--JF7FJL7F-J||L7L7L7FJF7F7|LJFJLJ||LJFJFJL7||JFJ|F77|L-7.L7J.LF7.LJFJF7|JJ-L7
    -77L7FF|JF--F-JL--7L7||LJ|.FJL7F-JLJFJL-7L7L7LJFJJ||L7FJF--JF7L-7L|LJF-JL-7||FJLL7|L-JLJ|L7.L7F7LJF-J-|F-J|||L7||L7L7FJ7-|J7FJ.FL7J-LLJLL|.|
    |L7JLJJ|.L|FL7F--7L-J|L-7L7L7FJL---7|F7||FJFL7FJF7||FJL7L7F-J|F-JFJF-JF-7FJLJL7F-JL7|F--JFJF7LJ|F-JF-7||F7|L7FJLJFJFJ|-F7|F-7L7-L|-.|JF--|7.
    L|.FJ7F-|.|7FLJF7L-7FJF7|FJFJL7F7F-J|||FJL-7FJL7|||LJF-JFLJF-JL-7L7L7-|FJ|F---JL--7L7L--7L7|L-7|L-7L7LJ|||L7|L7F-J.L7L-7J7|F-7J|LJ|.|-L7-L-7
    |LJ-.LL-F7F7F7FJL7FJL-JLJL-JF-J|||F7LJ|L7F-JL7FJ||L-7|-F7F7L-7F-JFJFJFJ|-||F7F7F7FJFJF-7|FJ|F-J|F-J|L-7LJL7||FJL7F7J|F-JF77J.JF-J-FFJLLJ77||
    |-LF--L7|LJ|||L-7|L7F----7F-JF7||LJL-7L7|L7J-||FJL7FJL7|||L--J|F7|FJFJFJFJ||||||||FJ7L7LJL-JL7FJL--7F-JF7FJ|||F-J|L7|L--JL7|7.|7|.7LJ7LJ|LFJ
    J--J.LLLL-7LJ|F7||FLJ7F-7|L-7|||L7JF7|FJL7L7FJLJF-JL7FJ||L---7||||L-JFJ|L7|||||||||J|7L----7FJ|F---J|F-JLJFJLJ|F7L7||F----JF7F|F7F77F|7.|FLF
    |FL.FL|LF7L-7LJLJL---7|FJL-7LJ|L7|FJ|||F7L7LJF--JFF7|||||F7F-JLJLJF--JF--JLJ||LJ||L7LF7|F--J|FJ|F-7FJL7.F7L7F-J|L7|LJL---7FJ|F|LJ-F7-|LJ|FFJ
    ||JF7JF-JL--JF7F7F7F7LJL-7FJF-JFJ||FJ||||-|F-JF7F7||||FJ|||L---7F7L-7FL----7|L7FJL7|FJL7L--7LJFJL7|L7FJFJL7|L-7|FJL7F----JL7L7F7LFJ|F|7-JL|J
    |L7-F-L-----7|LJ||LJL---7|L7|F7L7||L7|LJ|FJ|F7|LJ|||||L7||L7F7FJ|L-7|F-7F7FJL-J|LF|||F-JJF7L-7|F7|L7||FJF-JL7FJ||F7||F7LF7FJFJ|L7L7|F|L7J|LL
    -.|L|J|.F---J|F-JL-7|F--JL-J|||-|||FJL7FJL7LJ||F-J||||FJ|L7||LJFJF7LJ|FJ||L---7L7FJLJL7F-J|F7|LJ||FJ||L7L-7-||7|||||LJL-J||FJF|FJFJL7-7.F|-.
    L-7.|.F7L-7F7|L7F--JFJF7F7F7LJL-J||L7FJ|7LL7FJ||F7||||L7|FJ|L-7|F|L7FJL-J|F7F7|FJ|F---JL-7||||F7||L7||FJF-JFJL7|||||F--7FJ||F7|L-JF-JJL|7JLJ
    FF.FF-LF--J|||J||F-7L7|||LJL---7FJ|FJL7L7LFJ|-|||||||L7||L7L7F|L7|FJL---7LJ||LJ||||F--7F-JLJ|||LJ|FJ|||FJF7L7FJ|LJLJL-7LJJ|||||F--JJ|||LJ.FJ
    FL-7J..L-7FJLJ|LJL7L7||||F-----JL7||F7L7L7L7|FJ||||||FJ||.L7|FJFJ||F7FF7L-7|L-7L7|LJF-JL---7LJL7FJL7|||L7||FJL7|F----7L-7FJ|||||F-7|L7JJ|FLJ
    -7J.|F|FLLJJJLJ|F7L7|LJLJL7F----7LJLJL7L7L7|LJFJ|LJ|||FJL7FJLJFJFJ||L-JL-7||F7|FJL-7L7F77F7L-7FJL-7||||FJ|||F7LJL-7F7L--JL7LJLJLJFJ7J|.JL77.
    L|--L7|7.L|-FJ.FJ|FJL-77F7LJF---JF----J-|FJ|F7L7L7FJ|||F-JL--7L7|FJL--7F-J|LJ||L7F-JFJ||FJ|F-J|F7FJLJ||L7||||L----J||-F7LFJF7F7F-J7|LFJL-LL7
    |JJ|LLF77|L||.FL7|L-7FJFJL--JF7F7L7JF7-FJL7LJL7L-JL7||||F7F-7|FJ||F--7||F7L-7||FJL-7|L|||FJL-7|||L--7||FJ|||L-7F--7|L-JL-JFJ|||L--7J77J7-LFF
    .F-7-L|JLL7LF---JL--JL7L-----JLJL7L7|L7L-7L7F7L-7F-J|||LJ|L7||L7||L-7||||L7FJLJ|F-7||FJ|||F7FJLJ|F7FJ|||FJLJF-J|F-JL7F--7FJ-LJL7F-JLLJFJ7-F|
    7|FL7.|-.LF-L-------7FJF7F-------JFJ|FJF7|FJ||F7||F7|||F-JF||L7|||F7||||L7||F--JL7|||L7|||||L--7|||L7|||L7F7L-7|L-7||L-7|L---7FJL-7-J|FFL.-|
    LJ.L-FJFL-FFF7F7F7F7|L-J|L-7F----7L-J|FJ|||FJ||LJLJ|||||F7FJL7||||||||||FJ||L-7F7|||L7|||||L7F7||||FJLJL-J||F7LJF7L-JF7|L----J|F7FJ.LJ.|J-L|
    ||7|7JL-J||FJLJ|||||L--7|F7LJF---JF-7|L7LJ|L7|L--7L||||LJ|L7FJ|||||||LJ||-||F-J|LJ||.|||||L7||LJLJLJF-----JLJL7FJ|F7FJ|L-7F7F7LJLJF777.|L-J|
    -LJ-7-J|LL-L7F7LJLJ|F7FJLJ|F7L---7|FJL7L7FJFJL7F7|FJ||L-7|FJ|FJLJ||||F-JL7|||F7L-7||FJ|LJL7||L---7F-JF7F----7FJL7|||L7|F-J||||F---JL7-7L7J.F
    |.FL77FFJ7.LLJL---7LJ|L--7|||F--7LJL7FJFJL7L7J||||L7|L7FJ||FJL--7||||L7F7||||||F-J||L7|LF7|||F---J|F7|LJF-7FJL--JLJL-JLJF7|||LJF-7F-J-7LJ7-|
    |.|L||||-F7LLF7F7FL-7|JF7||||L-7L---JL7L7.|FJFJ|||7|L7|L7|||F7F-JLJ||FJ||||||||L-7||FJL7|LJ||L--7FJ||L77L7LJF77F7F7F7F7FJ||LJF-J||L7J||77|.|
    LLJJF|||.LFF-JLJL---JL-JLJ|||F7L-----7L7|FJ|7|FJ||FJFJ|FJ|||||L7F-7||L7|LJ||||L7FJLJL7FJ|F7|L7F7||FJL-JF7L-7|L7|||||LJ||FJ|F-JF-7L-J-F.F|L-|
    L||..J7J-LFL7F-7F----7F--7LJLJL7FF7F7L7LJL7L7||FJ|L7L7|L7||LJL7LJFJ||FJ|F-J||L7||F---J|FJ||L7LJ||||F---JL--J|FJ|||LJF-J||J|L--JFJF---77-.7LL
    FFF-7--7F-LFJ|LLJF--7LJF7L--7F7L-JLJL-JF7||FJ||L-J||FJ|FJ|L--7L7FJ.LJL-J|F7|L-JLJL7F7FJL7|L7L-7||||L--------JL-JLJF7L--JL-JF7F-JL|F--JJF-7FJ
    FLL7F-.L.|FJFJ-LFJF7L--JL---J|L--------JL7|L7|L-7F-JL7|L7|F7FJFJL---7F--J||L--7F77|||L7FJL7L7FJ||LJF-------------7||F--7F--J|L7F7||F7L-J||L|
    L|L7JLF.F-L7|-F7L7|L7F7F-7F-7|F----------JL-JL--J|F-7||FJ||||7|F7F7FJL--7|L7F-J||FJ|L7|L7FJFJL7LJF7L-----7F-----7||LJF-JL-77L7LJLJLJ|7-F-F.|
    F|-|.-JFLLLLJ7||FJ|FLJLJFJL7LJL----7F7F-7F7F-7F-7|L7||||FJ|LJFJ|||LJF---JL7|L--J|L-JL||||||L-7|F-JL---7F7LJF-7F7||L-7L---7L-7|F--7F7L7-F-L-|
    J..L.J.|-LFLF-J|L7|F----JF-JJF-----J|||FJ|||FJ|FJL-JLJ||L7L-7L7||L7FL-7F-7||F7F7|F---JL7|L--7||L-7F7F7LJL--JLLJLJ|F7L7F7L|F-J|L-7LJL-J-|..-J
    FF.FF.----JJL-7L7LJL----7|F-7L-7F---J||L-JLJL-JL--7F7FJ|7L7FJ.LJL7|F--JL7LJ||LJLJ|F7F7FJ|F7FJLJF7LJLJL-------7FF7LJL7LJL7|L-7|F7L7J||JF7-|.7
    -J--L|FJJ.|LL7L7|F7F7F-7LJL7L7FJ|F---JL7F-7F7F7F-7LJ|L-JF-JL-7F--J|L7F7FJF-JL---7||||LJFJ|LJF--J|-F-----7F7F-JFJL7F7L---J|F-JLJ|FJ|L|J-|7LJJ
    |.||LLJJ.F77LFFJLJLJ|L7|F-7L7LJFJL-----JL7|||||L7|F7|F7FL-7F-JL--7L7LJLJ|L7F-7F-J|||L-7L7L-7L--7L7|F-7F7LJLJLFJF7LJL----7|L--7J|L-7F7J7|-J.|
    L7LL77J.F-777LL----7L-J|L7|7L--JJF7F7F7F-J||||L-JLJ|LJL-7FJL7FFF-JFJLF7F--JL7|L7FJ||F7|FJF7|F-7L7||L7LJL-----JFJL----7F-JL--7L7|F-JF77F77-L|
    L7|LL-7.L7L-7.FF-7|L--7|FJL7F7F7FJLJLJ||F7LJ|L----7L----JL-7L7FJF7|.FJLJF-7FJ|FJL7|LJ||L-JLJL7|FJLJFJF7F7F7F7FJF7F--7|L-7F7FL-JLJF-J|-FJF-JL
    |.FJF||FF|F-JF7L7|F7FFJ||F7LJLJ|L---7FJLJL7FJF7F-7L7F7F7F7FJFJL7||L7L-7FJFJL7||F-JL-7|L7F----J|L7F7|FJ||LJLJ|L-JLJF-JL-7LJL-7F---JF7|JJF7L-J
    FF||FFF--J|F-JL-JLJL7L7|LJL7F-7L----JL----JL-J|L7L7LJLJLJ|L-JF7||L7|F-JL7L7FJ||L-7F-JL-JL----7||LJLJL7|L--7FJF----JF7F7L----JL-7F-JLJF77L7LJ
    |-F-7|L--7|L-------7L7||LF-J|JL---------7F---7L7L7L7F7F-7L---J|LJF||L7F-JFJL7LJ7FJ|F---7F--7J||F7F7F7|L---JL7L-7F--JLJL7LF7JF7FJL---7-JL-77J
    |LL7L---7||F7F7F7F7L7||L7L--JF7F--------J|F--JFL-JFJ||L7L----7|F--J|.||F7|F7L-7FJFJL--7LJF7|FJ|||||||L---7F7L--J|F-7F-7L-JL7|LJF--7FJFJ7LL-7
    F--JF--7LJ|||||||||.||L7|F7F7||L---7F----JL7F7F7F7L7|L7|F7-F7LJL7F7L7||||LJL7FJL-JF7F7L-7|LJL7|||||||F7F7LJL-7F-JL7|L7L----J|F-JF7LJ.FJ|--J-
    |F-7|JLL-7||||||LJL-JL-JLJLJLJL7.F-J|F-----J|||LJ||LJFLJ|L-JL7F7||L7||LJL7F7||-LF7||||F-J|F-7|||LJLJLJLJ|F---J|F--JL-JFF7|F7|L--J|F-77-JL-|.
    LJFLJJ.LFJLJLJLJF7F-7F7F-7F7F-7L7L--JL---7F7|||F7L------JF7F-J|LJL7||L7F7LJ||L7FJLJ|||L-7|L7|||L7F7F---7LJF7F7|L---7F--JL7|||F---JL7|L|.|LJ-
    |L|-F7F7L-7F7F-7|||7||||FJ||L7L7L---7F7F7LJLJ|||L------7FJ|L-7L7F7||L7|||F7||FJL--7LJL--JL-JLJL-J|LJF--JF-JLJLJF7F7LJF---J|LJL7F7F-JL-7-|JJ.
    |JF-JLJL--J|LJFJ|||FJ|||L7||FJFL7F-7LJLJL---7LJL7F7F--7LJLL--JFJ||||FJ||||LJ||J.F-JF7F7F-----7F7FJ7FJF-7|F-7F-7|LJ|F7L-7F7|F--J|LJF---J||-FF
    ||L7F-7F-7FJF-JFJLJL-J||F||||F--JL7L-7F-7F77L--7LJLJF7L------7|FJ|||L7LJ||JLLJF-JF-J||LJLF---J|||F7L7|.LJ|LLJFJL7LLJL--J|LJL-7J|F-JF---7J7.|
    .-LLJFJL7LJJL7FJ.F----JL7||||L----JF-J|FJ|L---7|F7F-J|F-7F-7FJLJF||L7|J-||77.FL--J7F|L7F-JF--7||||L7LJF-7L--7L-7L-7F7F7FJF--7L-JL7FJF--JL7-7
    |.|-LL7FJF--7LJF-JF7F-7FJLJLJF77F--JF-JL7|F---JLJLJF7LJFLJFJL---7LJFJL7JLJ-7-F----77L-JL--JF-J|LJ|FJF7L7|F--JF7L--J|||||FJF7L-7F7LJFJ|||JLF7
    F.J7FLLJFL-7|F-JF7|||FJ|F7F7FJL7L---JF-7LJL7JF7F7F-JL7FF-7L----7||FL-7L7J.L-FL---7L-7|F----JF-JF7||FJL-JLJF-7|L----JLJLJL-JL-7|||F7L---77-FJ
    LF|-F7.F---J|L7FJ|||||FJ||||L-7L-----JFL7F-JFJLJ||F-7L7L7|F--7J||7JJL|FJL7|.LJ|F-JF7L-JF7F7FJF-JLJLJF--7F7|FJ|F---7F7F7F-----JLJLJ|F---J.LLJ
    .F||L|.L---7L7|||LJLJLJFJLJL-7L--------7|L--JF-7LJL7L7L-JLJF7||||JL--LJ7FJF.7FFL-7|L7F7||||L7L7F----JF7LJLJL-JL--7|||||L----7F7F-7|L---7F7JJ
    .L----F-J-FL7|LJF7F----JF7F-7L--7F-----JL----J.L-7FJ.L7F-7FJLJ-LJ||.L|J|J.LLJF-F-J|L|||||||FJ7LJF7F--JL----7F--7FJ||LJL7F7F-J|||FJL-7F7|FL|J
    .L7L7-J-LF--JL7L||L-----J||7L--7LJF---7F7F7F7F--7|L7F7LJ.LJF7F|FLJ-F.|7J|.77F77L-7L7||||||LJ7F7FJ|L-7F----7|L-7|L7|L-7FJ||L--JLJL-77LJLJ7F|J
    JLJ7||F||L-7F7L-JL7F7F7F7LJF7F7L-7|F--J|LJLJLJF-JL-J||F7F--JL-77|L7JFLF-L7LL7J||L|FJLJLJLJ-F7||L7L-7LJF---JL-7|L-JL--JL-JL7F-7F--7L-7-J||F7J
    L|L-7JFFF7-LJ|F7F7LJLJLJL-7|LJL-7LJL---JF7F---JF7JF7|LJ||F--7FJL7JL-7F||L.-FJ-|LFLJF|J|F77FJ||L-JF-JF7L-----7|L-----7|-F-7|L7||F7L7FJ|||-J|7
    F||FF7FF|L--7LJLJL-------7|L---7|F7F----JLJF---JL-JLJF7LJL-7LJJ7|.|J|FF|FF7|L-|JF7F7F7FJ|FJFJL-7FJF7||F7-F--JL7F---7L7FJFJL-JLJ|L7LJJ-FF7L|7
    LL-FL77JL--7|LF7F--7F----JL---7|||LJF7JF---JF--7F-7F7|L7F7FJF7JFF-LFF-7J-JL.|JL-|LJLJ|L7|L7|F--JL-JLJLJL7L---7|L-77L7|L7|JF7|F-JFJ-LL7|--7|J
    |7.-7.|7F--JL7|LJF7LJF7F-7F7F7LJ|L--JL-JF--7L-7||FJ|||FJ||L-JL-7--FFL7|.||.F-.LFL--7FJFJL-J|L-7F7F7F-7F7L---7|L7FJF7LJFJL-JL7|F-JF7J|FJ.|--7
    F7L-|-LL|F--7|L7FJS7FJLJJ||||L-7L---7F-7|F7L--JLJL-JLJ|FJ|F----JFF--7||7J.7L|-F|-LFJ|7L---7L7.LJLJLJF|||F--7LJFJL7||F7|F---7LJL--J|LJJ..L77J
    77LF-JFFLJF-JL-J|F-J|F---J|||F-JF7F7LJF|LJL--7F7F7F--7LJFJL--7F77|F7LJL7L--F7.-F77L7|F7F77L7L-7F7F--7||LJF7L-7L--J|||LJL--7L7F7F-7L7|7-|7L7.
    FFJ|L.FJ|F|F-7F-JL-7|L----JLJL--JLJL--7L--7F7LJLJLJF-JF7L---7LJL7LJL7F-J-|-JJ7.||-|||||||F7L-7|||L-7|LJF-JL--JF7F-JLJF7F--JFLJ|L7L-J7F7|JFL-
    LJFJ-LL7FLLJ.||F--7||F-----7F7F7F-7F-7L--7LJL--7F--JF7|L---7L7F-JF--JL7JJ|||LF-|L--JLJLJLJL--JLJL7FJL7-L------JLJF---J||F--7F7L7L7F-7J7J7-LJ
    ||LJ.|L7.|7F-|||F7LJ|L----7|||||L7|L7L7F7|7F7F7LJF7-|LJF7F-JLLJJ7L--7FJ.F-7J-LFL---7F7F----7F---7|L-7|F7F---7F---JF--7LJ|F-J||FL7LJFJ.|.--LF
    LL7.F|.|FFLJJLJLJL--JFF---JLJLJL-JL-JL|||L-JLJL-7|L7|F-JLJF-7F7F7F7FJL--JFJJ.|.F---J|||F---J|F--JL--JLJ|L--7LJ-F7||F7L--JL--JL-7|F-JLFF-L-7J
    FJ7.||-FJ||7.LF---7-F7L7F7F7F-7F7F---7LJL--7F---JL7||L7F7FJFJ|LJ||||F7F7FJL-77-L7F7FJLJL-7F7|L----7F--7L---JJF-JL-J|L7F-7F7F---JLJ||.L|.|.|7
    FLFL-77.|FFJ.|L7F7L7||FJ|LJLJJLJ|L7F-JF7|F7||F--7FJ||FJ|||FJ7L-7||LJ|||LJJ|L.|LLLJLJF----J|||F-7F7||F7L----7FJF7F7FJJLJL|||L--7F7LF-7JJ-7F-7
    J.JJ.|7F7LJ.LF7LJL7|||L-JJF----7L-JL-7||FJ|LJ|F-JL7LJL7|LJL7F7FJ||F-JLJF7||JF|.FF--7L-7F-7|LJL7LJLJ||L7F---J|FJLJ||F7JF7LJ|F--J|L-7JJJ..|LJ|
    LF|J|.FL77L||||F7FJLJ|F7F-JF7F7L-----J||L7L7L||F--JF7FJ|F7FJ||L7|||F7JFJL7F7FF7LL-7|F7LJ|LJFF7L---7|L7LJF7F-JL--7LJ|L-JL-7LJF-7|F-J.F77-J7.|
    .LJ-L-77FF---J|||L--7||||F-JLJL-----7FJ|FJFJFJLJF7FJLJF||LJL||||LJLJ|FJF-J|L7||F-7|LJL7F7F--JL---7LJ|L--JLJF----JF7|F----JJFJFJ||F7F7|F7LLFJ
    F||F|-F-LL---7LJL--7||||LJF-7F------J|FJL7|JL7F-JLJF---JL--7|L7L-7F-J|FJ-FJFJ||L7|L7F-J||L--7F7F7L---------JF-7F7||||F--7F7L7L7|LJLJL--7.|LJ
    F|77|-|LJF7F7L----7||||L7JL7|L-7F----JL--JL7FJL7F7FL-7F----JL7|F-JL7-|L-7|FJFJL-J|FJL-7||F7|LJLJL--------7F7L7||LJLJLJF-J|L-JFJ|F--7F7FJ.L7|
    FJ|L.F-7-|LJ|F---7|LJ|L7|F7|L-7LJF----7F7F7LJF-J||F7F|L--77F7||L7F7L-JF-J|L7|F--7LJF--J|||L-7F7F7F7-F7F--J|L-JLJF-7F--JF7|F-7L-JL-7LJ||J|.L.
    L-J-F7.J.L-7|L--7|L-7L7||||L-7|F7L---7LJ|||F7L7FJLJL-JF-7L7|LJL7LJ|F7FJF7|FJLJF7L-7|F7-|||F7LJLJLJ|FJ|L---JF7F7FJJ|L---JLJL7L-7F-7L-7LJ-7-|7
    L77FFL7LF--JL-77|L7JL7LJLJ|F7||||F--7L-7LJLJL7LJF----7L7L-JL--7L7FJ|||7||||LF-J|7FJ|||FJ|LJL-----7||FJJF7F-JLJ|L-7|F-7F----JF7LJ7|F-J7JFL7||
    .|FF7J7LL--7F7L7L7L77L7F-7LJ||LJ|L-7|F7L7F7FF|F7L---7|FJLF7LF7L7|L7|LJFJ||L7L-7L7L7|||L7L7F-7F---JLJL-7||L---7L--JLJ.|L-----JL7FFJL--7-J-L-7
    |-FJ||F7.F7LJL7L7|FJF7LJFJF7|L-7|F-J||L7LJL7FJ|L7F7FJ||F7|L7|L7||-|L77L7LJFJF-JFJFJLJ|FJFJL7|L---7F--7LJL----JF---7F-JF7F7F--7L7|F7F-JJ-7L-J
    LLL7L-J|FJL--7L7LJL-JL--JFJ|L--JLJF7LJFL---JL-JJLJ|L7||||L7LJFJ|L-JFJF7L7FJJL-7|FJF--JL7|FFJ|F---J|F-JF7F--7F-JF--J|F7||||L-7L-JLJ|L-7F-JFJ|
    J.LL--7|L-7F7L7L7F----7F-J7L--7F7FJL----7JF7F----7L-JLJ|||L-7L7L-7FJFJ|FJL7F--J|L7|F7FFJL7L7|L----JL7FJLJF7LJF-JJF7LJLJLJL-7L---7L|F-JJF7.FJ
    |7|LF-JL-7||L7L-J|F---J|F-----J|||F-----JFJLJF---JF-7F7||F-7L7|F-JL7L7LJF-JL--7L-J||L7L-7|FJL7F7F7F-J|7F7|L--JF-7|L-------7|F--7|7LJ.|LLF7J7
    |-LJL7F--JLJ|L---JL7F7FJ|F-7F-7|LJL7F7-F-JF--JF--7L7||||||FJFJ|L-7FJFJF7|F7F7-L-7FJL7|F7|||F7LJLJ|L-7|FJLJF7F-JFJ|F-------J|L-7LJJFL-7.|JF--
    7|LF-JL--7F7F-----7|||L7LJFLJLLJF-7LJL7|F-J-F7L7FJFJLJ||||L7L7L--JL7|FJLJ||||F7FJL7FJLJLJ|LJL--7FJF7LJL7F7|||F-JFJL7F---7F7L-7L7LJ77L|F|FJJ|
    L7.L-7F--J||L----7|LJL-JF----7F7L7L--7LJL---J|FJL7L--7|||L7L7|F7F-7||L-7FJ|||||L7FJL7F7F7L7F7LFJL-JL--7LJLJ||L--JF7LJF--J|L-7L-J.|LJ-L-JFJF|
    FFF--JL--7||F7F7FJL--7F7L---7LJL7L--7L7F7F-7FJ|F-JF7FJLJL7|FJLJ||FJ||F-JL7LJ|||FJ|F7LJLJL7||L7L7F7F---JF---J|F---JL--JF7FJF7L---7.|J|LL7F--7
    |JL---7F-J||||||L--7FJ||F7F7L--7L---JJLJ||FLJF||F-J|L7F7FJ|L7F7LJL7LJL7F7|F-J||L7||L--7F7||L7|-LJ|L7F-7L----JL7F7F7F--JLJFJL----JF-.J|JF-FJ.
    L.|F--JL--JLJLJ|7F-JL-J|||||F-7|F7F7F7F7LJF---J|L7FJ-||LJ.L7LJ|LF7L7F7LJ|||F7|L7|LJF--J|LJL-J|F-7|FJL7|F7F-7F-J|||LJF--7FJF7F77F7-7-JF-L.J-7
    F-LL-7F7F-7F7F7L7L7F7F7LJLJLJFJLJLJLJLJL-7L---7L-JL-7||F7F7|F-JFJL-J|L--J|LJ|L7||F-JF-7L-7F--JL7||L-7|LJLJ-LJF7|||F-JF7LJFJLJL-J|.F7LJL|FJF|
    F7.F-J|||FJ|LJL7|JLJLJL-----7|F7F77F7F---J|F7F|F7F7FJ|||LJ|||F7L---7|F7F-JF-JFJ|||F7L7|F-JL-7JFJ|L7FJ|F------JLJLJL--JL7||F-----J7JL7JFFJF-7
    LJ-|F7|LJ|FJF--JL-----------JLJLJL-JLJF---7||FJ|LJ||FJ|L-7|||||F--7|LJ|L-7L7FL7||||L7|||F7F-JFJFJ.|L7LJ.F-----7F-------JFJL----7F77JLFFL-LJ|
    L|FJ|LJF-JL7|F7F----------7F7F-7F--7F7|F--J||L7|F7LJ|FJF7||||||L-7||F-JF7|FJF7|||||FJ||LJ||F7L7|F7|FJLF7L----7|L--------JF7F---J|L77F7JFFJJ7
    FL|FJF7|F--JLJLJF---7F-7F-J|||FJ|F-J|||L-7FJ|FJ||L7FJ|FJ||LJ||L7FJLJL7FJ|||FJ|||||||FJL7FJ|||FJ||||L7FJL7F7F7||F-7F------JLJ|F--JFJF7J.L7F77
    LLLJL||LJF7F-7F-JF7FJL7|L--JLJL7|L7FJ|L-7||JLJFJ|FJL7|L7LJF7||||L---7||L|||L7|||||||L-7||FJ||L7LJ|L7|L-7||||||LJFJL----------JF7FJFJL-7LLFJL
    L7FF7|L--J||FJL7FJ|||FJL----7F7||FJL7L7FJ|L-7|L7|L--J|FJJFJ||L7|F7F-J||FJ||FJ||||LJL7FJLJL-JL7|7FJFJ|F-JLJ||LJF7L-7F----7F-7F-JLJ7|F--J7.|.|
    F--JLJF--7LJ|F7LJFJL7L-----7LJLJ||F7|FJ|FJF7|F-JL7F-7LJF7L7LJFJLJ|L-7LJ|FJ|L7|||L7F7||F7F7F--JL7|FJFJL-7F-JL--J|F-JL77F7LJ|LJ-F---JL7.|7L77F
    |F---7|.FJF7LJL7FJF7L------JF7F-J||||L7|L7|||L-7FJL7L-7|L-JF7L--7L7FJF-JL7L7|||L7||LJLJLJ||F7F7||L7L7F7|L7F7F7FJL--7L-JL--7F--JF-7F7L-7-7.F|
    LJ-F-JL7L-JL--7LJFJ|F7F7F---J|L-7||LJFJL7||||F-JL-7|F-JL--7|L7F-JFJ|.L7F7L7||||FJ|L-7F7F-J||||||L7L7|||L7||LJ|L--7FL7F7F--J|F--J-LJL--J-|-LJ
    LLFJF--JF--7F-JF7L7LJ||LJF---JF7|||FFJF7|LJLJL7F-7LJL7F7FFJL7|L-7L7L7-||L7|||LJ|FJF-J||L-7||LJ||FJFJ|||FJ||F-JF-7|F-J||L-7|||F--------7--JL|
    F-L7L7..L-7LJF7|L7L-7LJF-JF7F7||||L7|FJLJFF---JL7L7F7LJL7L7FJ|F-JJL7L7LJLLJ|L7FJL7L-7||F-J|L-7LJL7||LJ||FJ|L-7L7||L7FJ|F7L-JLJF7F-----J7.L||
    JJFL7|7LL7L7FJ|L7L7FJF-JF7|||LJ||L7||||F--JF7F--JFJ||F7FJF|L7|L-7F7L7|FF--7|FJL7FJF-J||L7FJF7L--7|L--7||L7L7FJFJ||FJL7||L7F7F7||L-7F-7LF-7-7
    |7L7||J-LJ.|L7L7L7||FJF-J|||L7JLJL|||L7|F7FJ||F-7L7||||L-7L7||F-J||FJL7|F-J||F7LJFJF7||FJ|FJL-7FJL-7FJLJLL7|L7L7LJ|F7|||FJ|||LJL--J|FJJL7|L|
    JJ|FLJ|LJ7LL-J.L7|||L7|-FJ|L7L---7|||FJLJLJFJLJFJFJ||||F7L7||LJ7FJLJF7LJL7L|LJL-7L7|||||FJ|F--JL--7|L--7.FLJ-L7|F-J|||||L7||L---7F-JL7.|F|-J
    |.-J.F7LJJLLLF--J|||FJ|FJFJFJF7F7|LJ||F7F--JF-7L7L-J||||L7||L7F-JF-7|L7F7L7L7F7FJFJ|||LJ|FJL7F7F7FJ|F-7L7F----J|L7FJLJ||FJ||F7F7LJF-7|7FL7.L
    -J.|F|7-7.F-JL--7|||L7|L7||L7||||L-7|||LJF-7L7L7L7F-J||L7LJL7|L-7|.|L7|||FJFJ|||||FJ|L-7||F7LJ||LJ.||FJFJL7F--7|F||F7JLJ|FJ||LJ|F-J|LJ|F|L7J
    ...|LLJLL7.|.|LLLJLJFJ|FJ|F-J|||L-7|LJL--JJ|FJ7L7|L7FJ|FJF--JL7FJ|FJFJ|||L7L7||L7||FJF-J|||L--JL--7LJ|FJF7||F-J|FJLJL7F-JL7|L-7|L7LJ7JFFF.-.
    |-F7-FLL|-LJ77|.LJJJL7|L7|L7FJ|L-7LJF------J|FF7LJFJ|FJL7|F--7|L7|L7L7||L7|FJ|L7|LJL7L-7LJL7F-7F-7L-7LJJ|||||F7|L--7FJL7F7||F7||FJ-F|7J||FJ7
    |F|J.L.F-7|LJ-LJJ.|.L|L7||FJ|FJF7L-7L-7F---7L7|L-7L-J|F7||L7FJL7|L7|FJ|L7LJL7|FJL7F-JF7L-7FJL7|L7|F7L---J|||LJ||JF7LJF-J|||LJ||LJJFLJJLFJLJJ
    |LJL-J--|L-F7JL7J-F7||FJ||L7|L7||F7L7FJ|F--JFJL-7L---J||||FJ|F7||FJLJ|L7L--7||L-7|L7FJ|F-JL7FJL7||||F7F7FJLJF-JL-JL7L|F-J|L7.|L7J.|J7FFJ-|L|
    FL7JLF.LF77.L-FJ7.777||LLJJLJ7||||L7||FJL-7FJF--JF---7|LJLJFJ|||||F-7F-JF--JLJF-J|FJL7|L--7||F-J|||LJ|||L-7|L7F7F-7L7LJF-JFJ-L7|77J|FFFJF---
    -F.FJLF7L7|7|.FL|7J|-LJ-F-----J|LJ|LJLJF--JL7L7F7||F-JL--7FJFJ|||LJFJL-7L----7L7FJL-7||F-7|||L-7||L-7|||F7|F-J||L7L7|F7L-7L7JL||||7|FLFF7L7.
    .-|L7|F|-J--77JLJLF|7FJLL--7F-7L------7L--7FJFJ|||FJF7F7FJ|FJFJ|L-7L7F-JF-7F-J|LJF--J|||7LJLJ|FJ||F7|||||LJL7FJ|FJFJLJL-7L-JLFLJ77F77.||LFJJ
    .FL|.-JL7|.JL77|JF||-L7F---J||L7F-----JF--J|FJFJ||L-J||LJL||-L7L7FJFJL7FJFJL----7L-7FJ|L---7F-JFJLJ||LJ||F7FJ|FJL7|F-7F7L-7J7JFLJ77LL-FL-JJ|
    F|--7|7-|-7|7JLLJL7JF|-L---7|F-JL-----7L7F7|L7|.LJ-F-JL--7||F-JFJL7|F-JL7L7F7F7FJF-JL7|F-7FJL7FJFF-JL7FJLJ|L7||F7||L7LJ|F-JJ7.||-|F-L--F.|JF
    -7-L7LJ7|.F|L-J.F.L--77J|.FJ||F7F7F---JL||||FJL7JF-JF7F7FJLJL-7|F7LJ|F7FJF||||||FL7F-J||FJ|F-JL-7L--7||F--JJ|||||||FJJ.|L7|F7-JF-LJFF7L-7L-7
    ||F7L77L7.-7-77L||J77LF-7F|FJ|||||L7|-|JLJ|||F7|FL--J|||L7F---JLJ|F7LJ|L-7LJ||||F7|L-7||L7||F7F7L7.FJ||L7-F-J|LJLJ||J--L-J7LJ--F-|LLJ-.F77LF
    --7.FL-FJ.L.|FFJ|7.|FFL7LLLJ.LJ||L7L-77-|JLJ||LJF----J|L-JL7F-7F7LJL-7L7FJLFJ||||LJF-J|L7||||||L7L7L7|L7|JL7FJ.LLL|L77L|J.|7|7.F--L7J-FF||.7
    L|L7J.LJ-7F|7.F7.|FJ-|FL.LJJ.LFJ|FJF7L7J.-F-JL7FJF7F-7L-7F-JL7|||F--7L7LJF-JFJLJ|F-J.LL7|LJ||LJFJFJ-LJ.LJ|F||J7.|L|FJ7F|-J|-|--J.|.F7-|L|LJJ
    .L7JL7F||LL7LL7L7LJ|--7.|J|7F7L7|L7||FJ7FFL-7FJL7||L7L7FJ|F7FJ|||L-7L-J|.L--J7JF|L7.JJL||JFJ|LLL-JJ||-LLJ-FLJ.F--.LJJ|F|7F|J|7J7L|7|LJJF-7F-
    7JFJLFFJ|JLJ|FL7.L-L-LLL-F-LL-FJ|J||LJ7L|JLL||J-LJL-JJ||FJ|||FJ|L-7L-7JL7|JJ-J-7L-J7J7FLJLL7|L|LL7.LF-7J|L77L|L|L7L|-J-7J7.F-JF|FLL7LF-J|.J|
    7|F7.-J.||F|FJ.|.F-J.--7-F-|7FL-J-LJ|.JFJ.|LLJJL||F---J|L-J||L7L7FJF-J.L-J|7.L|7-J-JFL7LJ.LLJ7-JFJ7LFJJ-F-.F.7-|7F7|FJF|.F-7J.|LJ-||-7J.-F-|
    L|7-7|F7--FF7--JF-7L7.|77|L|FJL|.7LJFJ.|L7F|-L.F|FL---7L7F-J|J|FJL7L-77J|-|--.LL-J.F|7||.LL|F77.|-FF7JJF-7-|7||JFFL-|.FJ7.7LFF-FJLLJJ.L-7.7-
    LLF--FF|F7-JJF|.|FJJFL7LF7-|.J--.L-F7.FJF|-77|.FLLJ7.F|FJL-7|FJL-7|F7|JFJ|J|JL--.L7JLJ7|.L|L-JF7|.FJ|.L777FJ-77|-7J-J-JL77|-F|7.F-7JL7-|7|.L
    |-|7|.|F7L|JFF7-.L.||-L.FJ.L.J7|FFJ||.|--|-FJ-7LLLL|.FJL7F7||L7F-JLJLJLJ-J.J7F777.||7FFF7F7LLJL.L-J7L7F||7LL7LF-JL--L7.L-J|FFJ-|7FF7FL7-|7J|
    FF--7FLLJF|7FF-.|.-7|7LF7J-L7|L-JJ7|77JJ..LL7F|FL|.L-L7FJ|LJL7||.F7JJJ..L|7J-FF7F|||FLLFFF|.|7|-|.F-JF-LL-F7L-JF-J77F-|7J-F.|JJLJJ|F||L|.|-J
    F77|LF|7F7L77L|.J.|JL|-7||LLFFJJJ7FJ||--7F7.FL-|FJ77|-LJFJF7FJ|L-J|7FFJ7F-7--L|7F--|J.F---J-F7J--7|.F|J-7F7J.J.FL.FFFJ|7LF-7L7.J|F|L||-L-77|
    L-JJL-JJJL7JL-L-JJJFJJLF-L-.F7.|LLL--J7J-LFL7L|JJJF-J7..L-JLJJL---J-LF-LJJL7.LLJJJJJLJ.L|J-LFLJL-L--|JJ-LLJL|J-|.-J|.L|JL|JJ.FF--7L-FJ-LJ.J-
""".trimIndent()

val part2TestInput = """
    FF7FSF7F7F7F7F7F---7
    L|LJ||||||||||||F--J
    FL-7LJLJ||||||LJL-77
    F--JF--7||LJLJ7F7FJ-
    L---JF-JLJ.||-FJLJJ7
    |F|F-JF---7F7-L7L|7|
    |FFJF7L7F-JF7|JL---7
    7-L-JL7||F7|L7F-7F7|
    L.L7LFJ|||||FJL7||LJ
    L7JLJL-JLJLJL--JLJ.L
""".trimIndent()

val test2Input = """
    ..F7.
    .FJ|.
    SJ.L7
    |F--J
    LJ...
""".trimIndent()

val part2TestInput2 = """
    ...........
    .S-------7.
    .|F-----7|.
    .||.....||.
    .||.....||.
    .|L-7.F-J|.
    .|..|.|..|.
    .L--J.L--J.
    ...........
""".trimIndent()

val part2TestInput3 = """
    ..........
    .S------7.
    .|F----7|.
    .||....||.
    .||....||.
    .|L-7F-J|.
    .|..||..|.
    .L--JL--J.
    ..........
""".trimIndent()

val part2TestInput4 = """
    .F----7F7F7F7F-7....
    .|F--7||||||||FJ....
    .||.FJ||||||||L7....
    FJL7L7LJLJ||LJ.L-7..
    L--J.L7...LJS7F-7L7.
    ....F-J..F7FJ|L7L7L7
    ....L7.F7||L7|.L7L7|
    .....|FJLJ|FJ|F7|.LJ
    ....FJL-7.||.||||...
    ....L---J.LJ.LJLJ...
""".trimIndent()

fun part1other() {
}

fun part2(values: List<Long>) {
}



class Tile(
    val x: Int,
    val y: Int,
    val exits: Map<Direction, Tile?>,
    val char: Char
) {

    fun getExits(): Set<Direction> {
        return exits.keys
    }

}

fun parseChar(char: Char, row: Int, col: Int): Tile {
    return when (char) {
        '|' -> Tile(
            row, col, mutableMapOf(
                Direction.NORTH to null,
                Direction.SOUTH to null
            ), char
        )

        '-' -> Tile(
            row, col, mutableMapOf(
                Direction.EAST to null,
                Direction.WEST to null
            ), char
        )

        'L' -> Tile(
            row, col, mutableMapOf(
                Direction.NORTH to null,
                Direction.EAST to null
            ), char
        )

        'J' -> Tile(
            row, col, mutableMapOf(
                Direction.NORTH to null,
                Direction.WEST to null
            ), char
        )

        '7' -> Tile(
            row, col, mutableMapOf(
                Direction.SOUTH to null,
                Direction.WEST to null
            ), char
        )

        'F' -> Tile(
            row, col, mutableMapOf(
                Direction.SOUTH to null,
                Direction.EAST to null
            ), char
        )

        '.' -> Tile(
            row, col, mutableMapOf(),
            char
        )

        'S' -> Tile(
            row, col, mutableMapOf(),
            char
        )

        else -> error("Unexpected character")
    }
}

fun getOpposite(direction: Direction): Direction {
    return when (direction) {
        Direction.NORTH -> Direction.SOUTH
        Direction.SOUTH -> Direction.NORTH
        Direction.EAST -> Direction.WEST
        Direction.WEST -> Direction.EAST
    }
}

// Too high: 616, 392
// wrong: 73
fun main(args: Array<String>) {
    val problemInput = part2TestInput4

    var startingTile = Tile(0, 0, mutableMapOf(), 'x')
    for ((row, line) in problemInput.lines().withIndex()) {
        for ((col, char) in line.withIndex()) {
            if (char == 'S') {
                startingTile = parseChar(char, row, col)
            }
        }
    }

    println("Starting tile is ${startingTile.x}, ${startingTile.y}")
    // find 2 exits:
    val row = startingTile.x
    val col = startingTile.y

    val lines = problemInput.lines()

    // Check NORTH (can I get here from there?)
    val canGoNorth = if (row > 0) {
        Pair(Direction.NORTH, parseChar(lines[row - 1][col], row, col).getExits().contains(Direction.SOUTH))
    } else Pair(Direction.NORTH, false)
    val canGoSouth = if (row < lines.size) {
        Pair(Direction.SOUTH, parseChar(lines[row + 1][col], row, col).getExits().contains(Direction.NORTH))
    } else Pair(Direction.SOUTH, false)

    val canGoWest = if (col > 0) {
        Pair(Direction.WEST, parseChar(lines[row][col - 1], row, col).getExits().contains(Direction.EAST))
    } else Pair(Direction.WEST, false)
    val canGoEast = if (col < lines.size) {
        Pair(Direction.EAST, parseChar(lines[row][col + 1], row, col).getExits().contains(Direction.WEST))
    } else Pair(Direction.EAST, false)

    println(
        """
        From the start, Can I go:
        NORTH: ${canGoNorth.second}
        SOUTH: ${canGoSouth.second}
        EAST: ${canGoEast.second}
        WEST: ${canGoWest.second}
    """.trimIndent()
    )

    // Pick a direction and count the length of the cycle:
    var direction = setOf(canGoEast, canGoNorth, canGoSouth, canGoWest)
        .first { it.second }

//    println("Going ${direction.first} first")
    val seen = mutableSetOf<Pair<Int, Int>>()
    var count = 1

    var currentTile = startingTile

    do {
        seen.add(Pair(currentTile.x, currentTile.y))
//        println("looking at square ${currentTile.x}, ${currentTile.y}")
        val nextSquare = when (direction.first) {
            Direction.NORTH -> {
                parseChar(lines[currentTile.x - 1][currentTile.y], currentTile.x - 1, currentTile.y)
            }

            Direction.SOUTH -> {
                parseChar(lines[currentTile.x + 1][currentTile.y], currentTile.x + 1, currentTile.y)
            }

            Direction.EAST -> {
                parseChar(lines[currentTile.x][currentTile.y + 1], currentTile.x, currentTile.y + 1)
            }

            Direction.WEST -> {
                parseChar(lines[currentTile.x][currentTile.y - 1], currentTile.x, currentTile.y - 1)
            }
        }
        if (nextSquare.getExits().toMutableSet().singleOrNull { it != getOpposite(direction.first) } == null) {
            println("Guess I'm at the end now? after $count moves (${count / 2})")
            break
        }
        count++
        direction = Pair(nextSquare.getExits().toMutableSet().single { it != getOpposite(direction.first) }, true)
        // there should only be one valid exit.
//        println("moving $direction")
        currentTile = nextSquare

    } while (!seen.contains(Pair(nextSquare.x, nextSquare.y)))

    // left to right
    var map = mutableListOf(StringBuilder())
    for ((row, line) in problemInput.lines().withIndex()) {
        var insidePipeline = false
        var thisLine = StringBuilder()

        for ((col, char) in line.withIndex()) {
            if (seen.contains(Pair(row, col))) {
                insidePipeline = !insidePipeline
                thisLine.append('x')
            } else {
                if (insidePipeline) {
                    thisLine.append('I')
                } else {
                    thisLine.append('?')
                }
            }
        }
        map.add(thisLine)
    }

    map = map.filter { it.toString().isNotBlank() }.toMutableList()

    // right to left
    for (i in map.size - 1  downTo 0) {
        var insidePipeline = false
        for (j in map[0].length - 1 downTo 0) {
            if (map[i][j] == 'x') {
                insidePipeline = !insidePipeline
                map[i].setCharAt(j, 'x')
            } else {
                val currentChar = map[i][j]
                if (insidePipeline) {
                    if (currentChar == 'I') {
                        map[i].setCharAt(j, 'I')
                    } else {
                        map[i].setCharAt(j, '?')
                    }
                } else {
//                    map[i].setCharAt(j, '.')
                }
            }
        }
    }

    // Top to bottom
    for (i in 0 until map[0].length) {
        var insidePipeline = false
        for (j in map.indices) {
            if (map[j][i] == 'x') {
                insidePipeline = !insidePipeline
                map[j].setCharAt(i, 'x')
            } else {
                if (map[j][i] == '?') {
                    if (insidePipeline) {
                        map[j].setCharAt(i, 'I')
                    } else {
//                        map[j].setCharAt(i, '.')
                    }
                }
            }
        }
    }

    // bottom to top
    for (i in map[0].length - 1 downTo  0) {
        var insidePipeline = false
        for (j in map.size - 1 downTo 0) {
            if (map[j][i] == 'x') {
                insidePipeline = !insidePipeline
                map[j].setCharAt(i, 'x')
            } else {
                if (map[j][i] == '?') {
                    if (insidePipeline) {
                        map[j].setCharAt(i, '?')
                    } else {
//                        map[j].setCharAt(i, '.')
                    }
                }
            }
        }
    }


    for (line in map) {
        println(line)
    }

    println("Sum of inside tiles is ${map.map { it.count { it == '?' } }.sum()}")

    val startTime = System.currentTimeMillis()

    val endTime = System.currentTimeMillis()
    println("millis elapsed ${endTime - startTime}")
}
