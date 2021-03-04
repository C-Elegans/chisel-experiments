package hello

import org.scalatest._
import chiseltest._
import chisel3._

class HelloTest extends FlatSpec with ChiselScalatestTester with Matchers {
  behavior of "Hello"

  it should "Add numbers" in {
    test(new Hello) {c =>
      for(a <- 0 to 10) {
        c.io.a.poke(a.U)
        c.io.b.poke(a.U)

        c.clock.step(1)
        c.io.o.expect((a+a).U)

      }
    }
  }
}
