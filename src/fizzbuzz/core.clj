(ns fizzbuzz.core)

(defn mult-seq [n s]
  (apply concat (repeat (concat (repeat (dec n) nil) [s]))))

(defn fizzbuzz
        "Takes a map of multiplicands and strings"
        [rules] (->> rules
                 (map (fn [[k v]] (mult-seq k v)))
                 (apply map str)
                 (map #(if (empty? %2)
                         (inc %)
                         %2)
                      (range))))