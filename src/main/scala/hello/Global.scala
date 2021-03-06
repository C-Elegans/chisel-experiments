package hello

import chisel3._

class Global(extensions: List[HardwareExtension[Global]]) extends Module{
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

object AssembledGlobal {
  val extensionlist = CreateAdder :: Nil;
  def getGlobal() : Global = {
    new Global(extensionlist)
  }

}


