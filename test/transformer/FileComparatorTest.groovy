package transformer

class FileComparatorTest extends GroovyTestCase {

    private FileComparator simpleFileComparator

    private List<String> simpleCompare1File

    private List<String> simpleCompare2File

    private FileComparator fileComparator

    private List<String> compare1File

    private List<String> compare2File

    void setUp() {
        FileReader fileReader = new FileReader('resources/compare1.txt')
        simpleCompare1File = fileReader.getFileData()

        fileReader = new FileReader('resources/compare2.txt')
        simpleCompare2File = fileReader.getFileData()

        simpleFileComparator = new FileComparator(simpleCompare1File, simpleCompare2File)

        String matchColumnName = 'id'
        List<Column> columns = new ArrayList()
        columns.add(new Column(matchColumnName, 6, 1))
        columns.add(new Column('Banana', 2, 2))
        columns.add(new Column('Carrot', 5, 2))

        fileReader = new FileReader('resources/record1.txt')
        compare1File = fileReader.getFileData()

        fileReader = new FileReader('resources/record2.txt')
        compare2File = fileReader.getFileData()

        fileComparator = new FileComparator(compare1File, compare2File, matchColumnName, columns)
    }

    void tearDown() {
        simpleFileComparator = null
        simpleCompare1File = null
        simpleCompare2File = null
    }

    void testRowsCommon() {
        List<String> expected = new ArrayList<String>()
        expected.add('compare1')
        expected.add('compare2')
        expected.add('compare3')
        expected.add('compare4')
        expected.add('compare5')
        expected.add('compare6')
        expected.add('compare7')
        assert simpleFileComparator.common() == expected
    }

    void testRowsDeltaLeft() {
        List<String> expected = new ArrayList<String>()
        expected.add('fdsgsgsdgdsgdg')
        assert simpleFileComparator.deltaLeft() == expected
    }

    void testRowsDeltaRight() {
        List<String> expected = new ArrayList<String>()
        expected.add('wewerwrewe')
        assert simpleFileComparator.deltaRight() == expected
    }

    void testRowsCommonWithColumnNames() {
        List<String> expected = new ArrayList<String>()
        expected.add('1Some  1S  1Some')
        expected.add('2Some  2S  2Dumb')
        expected.add('3Some  3S  3Some')
        expected.add('5Some  5S  5Some')
        expected.add('6Some  6S  6Dumb')
        expected.add('7Some  7S  7Dumb')
        expected.add('10Some 10  10Som')
        assert fileComparator.common() == expected
    }

    void testRowsDeltaLeftWithColumnNames() {
        List<String> expected = new ArrayList<String>()
        expected.add('0Some  0S  0dfds')
        expected.add('4Dumb  4S  4wrew')
        expected.add('8Some  8S  8Some')
        expected.add('9Some  9S  9Dumb')
        assert fileComparator.deltaLeft() == expected
    }

    void testRowsDeltaRightWithColumnNames() {
        List<String> expected = new ArrayList<String>()
        expected.add('0Some  0S  0Some')
        expected.add('4Dumb  4S  4Some')
        expected.add('8Some  8S  8wert')
        expected.add('9Somd  9S  9Dumb')
        assert fileComparator.deltaRight() == expected
    }
}
