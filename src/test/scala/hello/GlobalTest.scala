package hello

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.stage.ChiselStage

class GlobalTest extends FlatSpec with ChiselScalatestTester with Matchers {
  behavior of "Global"

  it should "Add numbers" in {
    var extensionlist = CreateAdder :: Nil;
    test(new Global(extensionlist)) {c =>
      for(a <- 0 to 10) {
        c.io.a.poke(a.U)
        c.io.b.poke(a.U)

        c.clock.step(1)
        c.io.o.expect((a+a).U)

      }
    }
  }
}
