class Product(val name: String, var price: Double, var stock: Int) {
}

class Bodega {
    val products: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product, cantidad: Int) {
        if (product.name == "") {
            println("Ingrese un nombre valido")
            return
        }
        if (products.contains(product)) {
            product.stock += cantidad
            println("Nuevo stock ${product.stock} ${product.name}")
            return
        }
        products.add(product)
        product.stock = cantidad
        println("producto agregado ${product.name}, ${product.stock} ${product.price}")
    }

    fun deleteProduct(product: Product, cantidad: Int) {
        if (!products.contains(product)) {
            return println("El producto ${product.name} no fue encontrado")
        }
        product.stock -= cantidad
        println("El producto ${product.name} ha sido vendido")
        println("Stock actualizado = ${product.stock} ${product.name}")
    }

}

class Empleado(val DNI: Int, val nombre: String) {
    var salario = 0
    val peridoPago = "mensual"
    var area = ""
    var edad = 0

    var bodega = Bodega()
    var vendidos = 0
    var dineroTotal = 0.0
    fun cargarStock(product: Product, cantidad: Int) {
        bodega.addProduct(product, cantidad)
    }

    fun venderProducto(product: Product, cantidad: Int) {
        if (cantidad > product.stock || product.stock == 0) {
            println("producto insuficiente para ser vendido")
        } else {
            bodega.deleteProduct(product, cantidad)
            dineroTotal = dineroTotal + (product.price * cantidad)
        }
       // dineroObtenido(product)

    }

    private fun dineroObtenido(product: Product) {
        val total = product.price * product.stock
        dineroTotal = total
    }

    fun corteCaja() {
        println("Dinero total obtenido $dineroTotal")
    }
}

fun main() {

    var television = Product("television", 6500.05, 0)
    var licuadora = Product("licuadora", 2500.05, 0)
    var refrigerador = Product("refrigerador", 5500.00, 0)

    var negocio1 = Empleado(123, "Sergio")
    var negocio2 = Empleado(456, "Antonio")
    var negocio3 = Empleado(789, "Beatriz")

//    negocio1.cargarStock(television,10)
//    negocio1.venderProducto(television,2)
//    negocio1.cargarStock(television,2)
//    negocio1.venderProducto(television,1)
//    negocio1.corteCaja()

    negocio1.cargarStock(television, 90)
    negocio2.cargarStock(licuadora, 90)
    negocio3.cargarStock(refrigerador, 90)

    //dia 1
    negocio2.venderProducto(licuadora, 15)
    //dia 2
    negocio3.cargarStock(refrigerador, 10)
    //dia 3
    negocio1.venderProducto(television,5)
    //dia 4
    negocio1.cargarStock(television,1)
    //dia 5
    negocio2.venderProducto(licuadora,10)
    //dia 6
    negocio3.venderProducto(refrigerador, 10)
    //dia 7
    negocio2.cargarStock(licuadora,10)
    //dia 8
    negocio1.cargarStock(refrigerador,5)
    negocio3.venderProducto(refrigerador, 5)
    //dia 9
    negocio2.cargarStock(television,7)
    negocio1.venderProducto(television,7)
    //println("compro al negocio1")
    //negocio2.cargarStock(refrigerador,7)
    negocio3.venderProducto(refrigerador, 7)
    //dia 10
    //println("vende negocio1")
    //negocio1.venderProducto(television,5)
    println("vende negocio2")
    //negocio2.venderProducto(licuadora,5)
    println("vende negocio3")
    negocio3.venderProducto(refrigerador, 5)
    negocio1.corteCaja()
    negocio2.corteCaja()
    negocio3.corteCaja()
}