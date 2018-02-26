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

        fileComparator = new FileComparator(compare1File, compare2File, 'id')
    }

    void tearDown() {
        fileComparator = null
        compare1File = null
        compare2File = null
    }

    void testRowsCommon() {
        List<String> expected = new ArrayList<String>()
        assert fileComparator.common() == expected
    }

    void testRowsDeltaLeft() {
        List<String> expected = new ArrayList<String>()
        assert fileComparator.deltaLeft() == expected
    }

    void testRowsDeltaRight() {
        List<String> expected = new ArrayList<String>()
        assert fileComparator.deltaRight() == expected
    }
}
