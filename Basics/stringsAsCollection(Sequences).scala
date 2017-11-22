val str = "Learning scala is fun"

// filter
str.filter(_<'i')
str.filter(c => "aeiou".contains(c))

// split - arguments of split is regex
str.split(" ")
str.splitAt(3)