import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import scala.reflect.runtime.universe._

@kase class C[T](x: T, y: Int = 2)(val z: Boolean, val w: String = "")

class KaseThorough {
  val c = C("42")(true)

  @Test
  def construction = {
    assertThat(c.toString, is("C(42,2)"))
    assertThat(new C("42")(true).toString, is("C(42,2)"))
    assertThat(c.x, is("42"))
    assertThat(c.y, is(2))
    assertThat(c.z, is(true))
    assertThat(c.w, is(""))
  }

  @Test
  def deconstruction = {
    val C(x, y) = c
    assertThat(x, is("42"))
    assertThat(y, is(2))
  }

  @Test
  def copy = {
    val c1 = c.copy(x = 42)(false, "copied")
    assertThat(c1.toString, is("C(42,2)"))
    assertThat(c1.x, is(42))
    assertThat(c1.y, is(2))
    assertThat(c1.z, is(false))
    assertThat(c1.w, is("copied"))
  }

  @Test
  def product = {
    assertThat((c: Product).productPrefix, is("C"))
    assertThat(c.productElement(0), is[Any]("42"))
    assertThat(c.productElement(1), is[Any](2))
    assertThat(c.productIterator.toList, is(List("42", 2)))
  }

  @Test
  def equality = {
    assertThat(c, is(c))
    assertThat(c, notNullValue())
    assertThat(c, is(C("42")(true)))
    assertThat(c, is(C("42")(false, "something different")))
    assertThat(c, not[Any](C(43)(true)))
  }
}
