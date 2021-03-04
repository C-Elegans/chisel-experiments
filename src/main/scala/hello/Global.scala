package hello

import chisel3._

trait HardwareExtension {
  def elaborate(g:Global)
}

class Global(extensions: List[HardwareExtension]) extends Module{
  val io = IO(new Bundle{
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))

    val o = Output(UInt(8.W))
  })

  val out = Reg(UInt(8.W))

  io.o := out
  for (ext <- extensions) {
    ext.elaborate(this)
  }
}


object CreateAdder extends HardwareExtension{
  def elaborate(g:Global) {
    g.out := g.io.a + g.io.b
  }
}
