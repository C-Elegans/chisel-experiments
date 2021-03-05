package hello

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.stage.ChiselStage
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class GlobalTest extends FlatSpec with ChiselScalatestTester with Matchers {
  behavior of "Global"

  it should "Add numbers" in {
    test(AssembledGlobal.getGlobal()).withAnnotations(Seq(VerilatorBackendAnnotation)) {c =>
      val stage = new ChiselStage
      println(stage.emitVerilog(AssembledGlobal.getGlobal()))
      for(a <- 0 to 10) {
        c.io.a.poke(a.U)
        c.io.b.poke(a.U)

        c.clock.step(1)
        c.io.o.expect((a+a).U)

      }
    }
  }
}
