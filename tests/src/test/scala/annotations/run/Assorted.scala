import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._


import scala.reflect.runtime.universe._

class AssortedZoo {
  @doubler def foo(x: Int) = x
  @doubler val bar = 2
  @doubler var baz = 3
  @doubler lazy val bax = 4
  @doubler type T = Int
}

class Assorted  {

  @Test
  def testNested {
    assertThat(typeOf[AssortedZoo].decls.sorted.map(_.toString).mkString("\n"), is( """
      |constructor AssortedZoo
      |method foofoo
      |value barbar
      |value barbar
      |variable bazbaz
      |variable bazbaz
      |variable bazbaz
      |lazy value baxbax
      |type TT
    """.trim.stripMargin))
  }

  @Test
  def destLocal = {
    @doubler def foo(x: Int) = x
    @doubler val bar = 2
    @doubler var baz = 3
    @doubler lazy val bax = 4
    @doubler type T = Int

    assertThat(foofoo(1), is(1))
    assertThat(barbar, is(2))
    assertThat(bazbaz, is(3))
    assertThat(baxbax, is(4))
    assertThat(List[TT](5), is(List(5)))
  }
}
