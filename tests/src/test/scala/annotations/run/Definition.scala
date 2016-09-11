import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.Test
import scala.reflect.runtime.{currentMirror => cm}

class Definition {

  @Test
  def macroAnnotationsGetTheMACROflag = {
    assertThat(cm.staticClass("identity").isMacro, is(true))
  }
}