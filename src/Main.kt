fun main() {
    class Product(val name:String, var price:Double, var stock:Int ){
    }
    class Bodega {
        val products:MutableList<Product> = mutableListOf()

        fun addProduct(producto: Product){
            if(!products.contains(producto)){
                products.add(producto)
                println("producto agregado ${producto.name}, ${producto.stock}")
            }else{
                println("stock actual ${producto.stock}")
                var newStock = producto.stock
                newStock += producto.stock
                println("Nuevo stock $newStock")
            }
        }
        fun deleteProduct(product: Product){
            if (products.contains(product)){
                products.remove(product)
                println("El producto ${product.name} ha sido eliminado")
            }else{
                println("El producto ${product.name} no fue encontrado")
            }
        }
    }
    class Empleado(val DNI:String, val nombre:String){
        var salario = 0
        val peridoPago = "mensual"
        var area = ""
        var edad = 0

        fun cargarStock(){}
        fun venderProducto(){}
    }

    val television = Product("television", 2500.05,10)
    val television2 = Product("television2", 2500.05,100)
    val refrigerador = Product("refrigerador", 5500.00,15)

    var bodega = Bodega()
    bodega.addProduct(television)
    bodega.addProduct(television)
    bodega.addProduct(refrigerador)
    bodega.addProduct(refrigerador)
    bodega.deleteProduct(television2)
    bodega.deleteProduct(television)
    bodega.deleteProduct(television)
}