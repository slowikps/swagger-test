import org.scalacheck.Prop
import org.scalacheck.Arbitrary
import org.specs2.ScalaCheck
import org.specs2.execute.Result
import org.specs2.mutable.Specification
import org.specs2.scalacheck.Parameters
import org.specs2.specification.BeforeAfterAll

class PropetyBasedTests extends Specification with ScalaCheck {

  "Should not work" in {
    dupa()
    prop { int: Int =>
      int must be greaterThan 0
    }
  }

  def dupa()(implicit arbitrary: Arbitrary[Int]): Unit = {
    print(arbitrary)
  }
}
