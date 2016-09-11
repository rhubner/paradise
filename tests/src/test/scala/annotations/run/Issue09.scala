import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.Test

object C09
@identity @placebo class C09

class Issue09 {

  @Test
  def testCompiles: Unit = {
    assertThat(true, is(true))
  }
}
