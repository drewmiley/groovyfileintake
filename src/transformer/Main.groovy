package transformer

def resourcesDirectory = './../../resources/'

def columns = new ArrayList()
columns.add(new Column('id', 6, 1))
columns.add(new Column('Banana', 2, 2))
columns.add(new Column('Carrot', 5, 2))

def recordGenerator = new RecordGenerator(columns)

def textGenerator = new TextGenerator("${ resourcesDirectory }Data1.txt", recordGenerator)
textGenerator.generateFile()

def input = new FileReader("${ resourcesDirectory }lines.txt")
input.print()

def compare1 = new FileReader("${ resourcesDirectory }record1.txt")
def compare2 = new FileReader("${ resourcesDirectory }record2.txt")

def fileComparator = new FileComparator(compare1.getFileData(), compare2.getFileData())
def commonData = fileComparator.common()
def textToWrite = ''

commonData.each { textToWrite += "${ it }\n"}

def fileWriter = new FileWriter(resourcesDirectory, 'commonData.txt', textToWrite)
fileWriter.write()
