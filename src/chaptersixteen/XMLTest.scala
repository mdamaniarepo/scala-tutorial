package chaptersixteen

import scala.xml._
import scala.xml.transform.RewriteRule
import scala.xml.transform.RuleTransformer

object XMLTest {

  def main(args: Array[String]): Unit = {
    val doc = <html><head><title>Fred's Memoirs</title></head><body>...</body></html>
    println(s"Class Type: ${doc.getClass}, XML: ${doc}");

    val items = <li>Fred</li><li>Wilma</li>
    println(s"Class Type: ${items.getClass}, XML: ${items}");

    val elem = <a href="http://scala-lang.org">The <em>Scala</em> language</a>
    println("Label: " + elem.label + ", Class Type : " + elem.label.getClass)
    println("Child: " + elem.child + ", Class Type : " + elem.child.getClass)
    println("scope: " + elem.scope + ", Class Type : " + elem.scope.getClass)
    println("Attrs: " + elem.attributes + ", Class Type : " + elem.attributes.getClass)

    val items1 = new NodeBuffer
    items1 += <li>Fred</li>
    items1 += <li>Wilma</li>
    val nodes: NodeSeq = items1

    println(nodes)

    // validate attributes
    println("Attribute Text: " + elem.attributes("href").text)
    val image = <img alt="San Jos&eacute; State University Logo" src="http://www.sjsu.edu/publicaffairs/pics/sjsu_logo_color_web.jpg"/>
    println(image.attributes("alt"))

    println(image.attributes("source"))
    println(image.attributes.get("source"))
    println(image.attributes.get("source").getOrElse("Default Source"))

    for (attr <- elem.attributes) {
      println(attr.key + " : " + attr.value)
    }

    println(image.attributes.asAttrMap)

    // XPath testing
    val list = <dl><dt>Java</dt><dd>Gosling</dd><dt>Scala <lang>functional</lang> Language</dt><dd>Odersky</dd></dl>
    val languages = list \ "dt"
    println("Languages: " + languages)

    val complicatedDoc = <html><head><title>Fred's Memoirs</title></head><body><dt>123</dt><ol><li>Java</li><li>Gosling</li><li>Scala</li><li>Odersky</li><dt>456</dt></ol><ul><li>Java</li><li>Gosling</li><li>Scala</li><li>Odersky</li></ul></body></html>
    val bookAuthor = complicatedDoc \ "body" \ "_" \ "li" // here the underscore denotes an abstract level
    println("bookAuthor : " + bookAuthor)

    val findDt = complicatedDoc \\ "dt"
    println("findDT : " + findDt)

    val alt = image \ "@alt"
    println("alt : " + alt)

    println((<img src="hamster.jpg"/><img src="frog.jpg"/> \\ "@src").text)

    for (language <- languages) {
      language match {
        case <dt>{ _ }</dt>  => println("found DT : " + language.text)
        case <dt>{ _* }</dt> => println("found DT with child elements : " + language.text)
        case _               => println("found something else")
      }
    }

    // To use variable names in matches
    for (language <- languages) {
      language match {
        case <dt>{ someText }</dt>      => println("found DT : " + someText.text)
        case <dt>{ someText @ _* }</dt> => println("found DT with child elements : " + someText.text)
        case _                          => println("found something else")
      }
    }

    // To use the text directly
    for (language <- languages) {
      language match {
        case <dt>{ Text(someText) }</dt> => println("found DT : " + someText)
        case _                           => println("found something else")
      }
    }

    elem match {
      case att @ <a>{ _* }</a> if (att.attributes("href").text == "http://scala-lang.org") => println("found HREF")
      case _ => println("Attribute Not Found")
    }

    // XML manipulation
    val someList = <ul><li>Fred</li><li>Wilma</li></ul>
    println(someList.copy(label = "ol")) // changing the label to ol

    println(someList.copy(child = someList.child ++ <li>Amyra</li>))

    val someImage = <img src="hamster.jpg"/>

    println(someImage % Attribute(null, "alt", "An image of a hamster", Null))

    println(someImage % Attribute(null, "src", "frog.jpg", Attribute(null, "alt", "An image of a frog", Null)))

    // XML transformation

    val rule1 = new RewriteRule {

      override def transform(n: Node) = n match {

        case e @ <ul>{ _* }</ul> => e.asInstanceOf[Elem].copy(label = "ol")
        
        case e1 @ <li>{ _* }</li> => e1.asInstanceOf[Elem].copy(label = "il")

        case _                   => n

      }

    }
    
    val transformed = new RuleTransformer(rule1).transform(someList)
    println(transformed)
  }

}