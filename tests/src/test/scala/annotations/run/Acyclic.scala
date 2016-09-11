import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.Test

class Acyclic {


  @Test
  def A {
    import acyclica._
    assertThat(C.toString, is("C"))
    assertThat(D.toString, is("D"))
    assertThat(new CX().toString, is("CX"))
    assertThat(new DX().toString, is("DX"))
  }

  @Test
  def B {
    import acyclicb._
    assertThat(CC.x.toString, is("DX"))
    assertThat(DD.x.toString, is("CX"))
  }
//
//  @Test
//  def C {
//    import Module4._
//    @identity4 class C4
//  }
}