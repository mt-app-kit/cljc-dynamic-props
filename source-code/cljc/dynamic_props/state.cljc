
(ns dynamic-props.state
    #?(:cljs (:require [reagent.core :refer [atom] :rename {atom ratom}])))

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
(def PROPERTIES #?(:clj  (atom  {})
                   :cljs (ratom {})))
