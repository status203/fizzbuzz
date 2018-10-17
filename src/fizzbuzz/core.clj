(ns fizzbuzz.core)

(defn mult-seq
  "Creates a cycling sequence of n-1 nils followed by s e.g. (nil nil \"fizz\" nil nil \"fizz\" nil...)"
  [n s]
  (cycle (concat (repeat (dec n) nil)
                 [s])))

(defn fizzbuzz
  "Takes a map of multiplicands and replacement strings and produces
 an infinite 'fizzbuzz' sequence"
  [rules]
  (->> rules
       (into (sorted-map))
       (map #(apply mult-seq %)) ; Convert rules( to cycling sequences
       (apply map str) ; Concatenate the strings in each position
       (replace {"" nil}) ; Replace any positions with no strings with a nil
       (map (fn [position replacement] ; Choose string if we have one, otherwise position
              (or replacement position))
            (iterate inc 1)))) ; Generate positions


; (take 30 (fizzbuzz {3 "fizz" 5 "buzz"}))
;; (1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz" 11 "fizz" 13 14 "fizzbuzz"
;; 16 17 "fizz" 19 "buzz" "fizz" 22 23 "fizz" "buzz" 26 "fizz" 28
;; 29 "fizzbuzz")

; (take 30 (fizzbuzz {2 "wibble" 3 "wobble"  5 "woo"}))
;; (1 "wibble" "wobble" "wibble" "woo" "wibblewobble" 7 "wibble"
;; "wobble" "wibblewoo" 11 "wibblewobble" 13 "wibble" "wobblewoo"
;; "wibble" 17 "wibblewobble" 19 "wibblewoo" "wobble" "wibble" 23
;; "wibblewobble" "woo" "wibble" "wobble" "wibble" 29 "wibblewobblewoo")
