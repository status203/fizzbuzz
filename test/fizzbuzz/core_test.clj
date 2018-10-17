(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer :all]))

(deftest multi-seq-test
  (are [n s truncate-at expected]
    (= expected (take truncate-at (mult-seq n s)))
    2 "even" 5 [nil "even" nil "even" nil]
    3 "tree!" 9 [nil nil "tree!" nil nil "tree!" nil nil "tree!" ]))

(deftest fizzbuzz-test
  (are [rules truncate-at expected]
    (= expected (take truncate-at (fizzbuzz rules)))
    {3 "fizz" 5 "buzz"} 15 [1 2 "fizz" 4 "buzz"
                            "fizz" 7 8 "fizz" "buzz"
                            11 "fizz" 13 14 "fizzbuzz"]
    {5 "buzz" 3 "fizz"} 15 [1 2 "fizz" 4 "buzz"
                            "fizz" 7 8 "fizz" "buzz"
                            11 "fizz" 13 14 "fizzbuzz"]))
