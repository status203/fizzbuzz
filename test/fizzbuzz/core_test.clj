(ns fizzbuzz.core-test
  (:use midje.sweet
        fizzbuzz.core))

(tabular
 (facts "about creating the cycles to combine"
        (fact (take ?truncate-at (mult-seq ?n ?s)) => ?result))

 ?truncate-at ?n ?s     ?result
 5           2  "even" [nil "even" nil "even" nil])

(tabular
 (facts "about calling fizzbuzz"
        (fact (take ?truncate-at (fizzbuzz ?rules)) => ?result))

 ?truncate-at ?rules              ?result
 15           {3 "fizz" 5 "buzz"} [1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz" 11 "fizz" 13 14 "fizzbuzz"])
