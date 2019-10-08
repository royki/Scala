class File(
    location: String,
    name: String,
    extension: String,
    content: String
) {
  def write(): Boolean = {
    println(s"Writing '$content' to '$location' ... ")
    Thread.sleep(1000)

    true // false
  }
}
