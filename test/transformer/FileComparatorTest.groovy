package transformer

class FileComparatorTest extends GroovyTestCase {

    private FileComparator fileComparator

    private List<String> compare1File

    private List<String> compare2File

    void setUp() {
        FileReader fileReader = new FileReader('resources/compare1.txt')
        compare1File = fileReader.getFileData()

        fileReader = new FileReader('resources/compare2.txt')
        compare2File = fileReader.getFileData()

        fileComparator = new FileComparator(compare1File, compare2File)
    }

    void tearDown() {
        fileComparator = null
        compare1File = null
        compare2File = null
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
        assert fileComparator.common() == expected
    }

    void testRowsDeltaLeft() {
        List<String> expected = new ArrayList<String>()
        expected.add('fdsgsgsdgdsgdg')
        assert fileComparator.deltaLeft() == expected
    }

    void testRowsDeltaRight() {
        List<String> expected = new ArrayList<String>()
        expected.add('wewerwrewe')
        assert fileComparator.deltaRight() == expected
    }
}
