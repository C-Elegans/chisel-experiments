package hello

import chisel3._

object CreateAdder extends HardwareExtension[Global]{
  def elaborate(g:Global) {
    g.out := g.io.a + g.io.a
  }
}
