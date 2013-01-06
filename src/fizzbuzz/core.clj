(ns fizzbuzz.core)

(defn mult-seq [n s]
  (cycle (concat (repeat (dec n) nil) [s])))

(defn fizzbuzz
        "Takes a map of multiplicands and strings"
        [rules] (->> rules
                 (map (fn [[k v]] (mult-seq k v)))
                 (apply map str)
                 (map #(if (empty? %2)
                         (inc %)
                         %2)
                      (range))))

(take 30 (fizzbuzz {3 "fizz" 5 "buzz"}))

(take 30 (fizzbuzz {2 "wibble" 3 "wobble"  5 "woo"}))
