package transformer

def textGenerator = new TextGenerator('resources/Data1')
textGenerator.generateFile()

def input = new FileReader('./../../resources/lines.txt')
input.run()
