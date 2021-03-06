//@Grab('net.sourceforge.nekohtml:nekohtml:1.9.22')
//@GrabExclude('xml-apis:xml-apis')
import org.cyberneko.html.parsers.SAXParser

def parser = new XmlSlurper(new SAXParser())
// id below assumes a freshly started server
def page = parser.parse('http://localhost:8080/viewPost?id=1')
assert page.BODY.H1.text().contains('Christmas')
assert page.BODY.H3[1].text() == 'Category: Home'
assert page.BODY.H3[2].text() == 'Author: Bart'
assert page.BODY.TABLE.TBODY.TR.TD.P.text() ==
        "Aren't we forgeting the true meaning of this day? You know, the birth of Santa."
