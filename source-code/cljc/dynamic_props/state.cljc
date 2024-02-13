
(ns dynamic-props.state
    #?(:cljs (:require [reagent.core :as reagent])))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @description
; Stored dynamic properties of components.
;
; @atom (map)
; {:my-component (map)}
;
; @usage
; (deref PROPERTIES)
; =>
; {:my-component {:my-prop "My dynamic property"}}
(def PROPERTIES #?(:clj  (atom         {})
                   :cljs (reagent/atom {})))
