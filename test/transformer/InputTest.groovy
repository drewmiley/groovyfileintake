package transformer

class InputTest extends GroovyTestCase {

    private Input input

    void setUp() {
        input = new Input('resources/lines.txt')
    }

    void tearDown() {
        input = null
    }

    void testConstructorSetsFile() {
        List<String> fileData = input.getFileData()
        assert fileData.size() == 5
        assert fileData.get(0) == 'line 1'
        assert fileData.get(1) == 'line 2'
        assert fileData.get(2) == 'line 3'
        assert fileData.get(3) == 'line 4'
        assert fileData.get(4) == 'line 5'
    }
}
