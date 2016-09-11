
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.Test

class Argumentative  {

  @Test
  def combo = {
    @argumentative(1, 2) object X

    assertThat(X.toString, is("1 2"))

  }
}