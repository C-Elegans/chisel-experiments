package hello

import chisel3._

class Hello extends Module{
  val io = IO(new Bundle{
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))

    val o = Output(UInt(8.W))
  })

  val out = Reg(UInt(8.W))

  out := io.a + io.b

  io.o := out
}
