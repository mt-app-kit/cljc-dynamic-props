
(ns dynamic-props.api
    (:require [dynamic-props.env          :as env]
              [dynamic-props.side-effects :as side-effects]
              [dynamic-props.state        :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial Dynamic properties
;
; Dynamic properties of components are ...
; ... stored in the property state atom.
; ... dynamically updated by functions.
; ... merged onto the component static property map (provided as parameter).
;
; @code Demo:
; (defn update-my-props!
;   []
;   (update-props! :my-component assoc :my-prop "My dynamic property"))
;
; (defn my-component
;   [component-props]
;   (let [component-props (import-props :my-component component-props)]
;        [:div [:button {:on-click update-my-props!} "Update properties"]
;              [:div "Properties of this component:" component-props]]))
; @---
;
; @code Cleaning up:
; (defn my-component
;   [component-props]
;   (reagent.core/create-class {:component-will-unmount (fn [_] (clear-props! :my-component))
;                               :reagent-render         (fn [_] [:div ...])}))



; @tutorial Source of truth
;
; @code Providing static properties for a component:
; (defn my-component
;   [component-props]
;   [:div "Properties of this component:" component-props])
;
; @code The output:
; (my-component {:my-prop "My static property" :another-prop "Another static property"})
; =>
; [:div "Properties of this component" {:my-prop "My static property" :another-prop "Another static property"}]
; @---
;
; @code Updating the dynamic properties of the component:
; (update-props! :my-component assoc :my-prop "My dynamic property")
;
; @code Merging the dynamic properties onto the static properties of the component:
; (defn my-component
;   [component-props]
;   (let [component-props (import-props :my-component component-props)]
;        [:div "Properties of this component:" component-props]))
;
; @code Let's see what happened:
; (my-component {:my-prop "My static property" :another-prop "Another static property"})
; =>
; [:div "Properties of this component" {:my-prop "My dynamic property" :another-prop "Another static property"}]
; @---

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

; @redirect (dynamic-props.state/*)
(def PROPERTIES state/PROPERTIES)
