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

    }

    void testRowsDeltaLeftWithColumnNames() {

    }

    void testRowsDeltaRightWithColumnNames() {

    }
}
