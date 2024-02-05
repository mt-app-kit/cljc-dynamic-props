
(ns dynamic-props.api
    (:require [dynamic-props.state :as state]
              [dynamic-props.env :as env]
              [dynamic-props.side-effects :as side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial Dynamic properties
;
; Dynamic properties of components are ...
; ... stored in the properties state atom.
; ... updated by functions.
; ... merged onto the component properties provided as a parameter.
;
; @usage
; (defn update-my-props!
;   []
;   (update-props! :my-component assoc :my-prop "My value"))
;
; (defn my-component
;   [component-props]
;   (let [component-props (import-props :my-component)]
;        [:div [:button {:on-click update-my-props!} "Update"]
;              [:p "Properties of this component:" (str component-props)]]))
; @---
;
; @usage
; (defn my-component
;   [component-props]
;   (reagent.core/create-class {:component-will-unmount (fn [_] (clear-props! :my-component))
;                               :reagent-render (fn [_] [:div ...])}))



; @tutorial Source of truth
;
; Once a property is updated dynamically by a function, it overrides the corresponding
; value in the properties map (provided as a parameter), even if its value is NIL!
;
; @code 1.) Providing static properties for a component:
; (defn my-component
;   [component-props]
;   [:div "Properties of the component:" component-props])
;
; (my-component {:my-prop "My static property"})
; =>
; [:div "Properties of the component" {:my-prop "My static property"}]
; @---
;
; @code 2.) Updating the dynamic properties of the component:
; (update-props! :my-component assoc :my-prop "My dynamic property")
;
; @code 3.) Merging the dynamic properties onto the static properties of the component:
; (defn my-component
;   [component-props]
;   (let [component-props (import-props :my-component)]
;        [:div "Properties of the component:" component-props]))
;
; @code 4.) Let's see what happened:
; (my-component {:my-prop "My static property"})
; =>
; [:div "Properties of the component" {:my-prop "My dynamic property"}]
; @---
;





;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (dynamic-props.env/*)
(def get-props    env/get-props)
(def import-props env/import-props)

; @redirect (dynamic-props.side-effects/*)
(def update-props! side-effects/update-props!)
(def clear-props!  side-effects/clear-props!)

; @redirect (dynamic-props.state/*)
(def PROPERTIES state/PROPERTIES)
