import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.Test
import scala.reflect.runtime.universe._

@identity case class InteropIdentity(x: Int)
@placebo case class InteropPlacebo(x: Int)

class InteropCaseSynthesis {

  @Test
  def testCaseModuleSynthesisForIdentity = {
    assertThat(InteropIdentity.toString, is("InteropIdentity"))
  }

  @Test
  def testCaseModuleSynthesisForPlacebo = {
    assertThat(InteropPlacebo.toString, is("InteropPlacebo"))
  }
}