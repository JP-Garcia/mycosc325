#lang racket

(define (sum lis)
  (if (empty? lis) 0 (+ (car lis) (sum (cdr lis)))))














(define (elementAt lis i)
  (if (= i 0) (car lis) (elementAt (cdr lis) (- i 1))))

















(define (median lis)
  (if (even? (length lis))
      (/ (+ (elementAt (sort lis <) (- (floor (/ (length lis) 2)) 1)) (elementAt (sort lis <) (floor (/ (length lis) 2)))) 2)
      (elementAt (sort lis <) (floor (/ (length lis) 2)))))




















(define (median2 lis)
  (let* ([len (length lis)] [sortedlis (sort lis <)] [middle (floor (/ len 2))])
    (if (even? len)
        (/ (+ (elementAt sortedlis (- middle 1)) (elementAt sortedlis middle)) 2)
        (elementAt sortedlis middle))))