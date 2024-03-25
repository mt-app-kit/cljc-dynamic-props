
(ns dynamic-props.api
    (:require [dynamic-props.env          :as env]
              [dynamic-props.side-effects :as side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial Demo
;
; @usage
; (defn my-button
;   []
;   [:button {:on-click #(merge-props! :my-button {:background-color :red})
;             :style     (import-props :my-button {})}
;            "My button"])

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (dynamic-props.env/*)
(def get-props    env/get-props)
(def get-prop     env/get-prop)
(def import-props env/import-props)

; @redirect (dynamic-props.side-effects/*)
(def update-props! side-effects/update-props!)
(def merge-props!  side-effects/merge-props!)
(def clear-props!  side-effects/clear-props!)
