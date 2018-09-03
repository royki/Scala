import org.scalatest._

class CCSuite extends FunSuite with Matchers {
	
	test("Create a card without passing any number should generate a valid CC") {
		CC().isValid shouldBe true
	}

	test("Creating a card without passing any number should create a card of class CC.Valid") {
		CC() shouldBe a[CC.Valid]
		CC().isInstanceOf[CC.Valid] shouldBe true
	}

	test("Creating a card manually by passing a valid number should produce a valid card") {
		val validNumber = CC().number
		CC(validNumber).isValid shouldBe true
		noException should be thrownBy CC(validNumber).asInstanceOf[CC.Valid]
	}

	test("Credit card's toString method should mention validity") {
		CC("").toString.toLowerCase should include ("invalid")
		CC().toString.toLowerCase should not include "invalid"
	}

	test("All these numbers should be valid") {
		val fakeCards = Set(
					        "0604326448044080",
					        "30166725723574",
					        "30257046091021",
					        "30294018909708",
					        "341187902765570",
					        "3541554640440604",
					        "3542693324121525",
					        "3589717201082460822",
					        "36268386338793",
					        "36631296369242",
					        "36766377557818",
					        "377560970646384",
					        "378140783126020",
					        "4026575583448348",
					        "4071885695832931",
					        "4091739759762839789",
					        "4175001001348662",
					        "4175002782178369",
					        "4929749206271704",
					        "5101460153519270",
					        "5204344410052968",
					        "5231960878190706",
					        "5427922224180173",
					        "5558772376417266",
					        "5588250087285979",
					        "5893046723149417",
					        "5893505008915446",
					        "6011062269562137775",
					        "6011278148379643",
					        "6011555484292906",
					        "6370424233370023",
					        "6380761773419647",
					        "6387887062135843",
				     	).map(CC)
		all(fakeCards.map(_.isValid)) shouldBe(true)
	}

	test("10K generated numbers should all be valid") {
		val fakeCards = 1 to 10000 map(_ => CC())
		all(fakeCards.map(_.isValid)) shouldBe(true)
	}
}

