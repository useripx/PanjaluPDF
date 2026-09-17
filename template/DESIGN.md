---
name: Aeris Authority
colors:
  surface: '#f9f9ff'
  surface-dim: '#cfdaf1'
  surface-bright: '#f9f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f0f3ff'
  surface-container: '#e7eeff'
  surface-container-high: '#dee8ff'
  surface-container-highest: '#d8e3fa'
  on-surface: '#111c2c'
  on-surface-variant: '#44474d'
  inverse-surface: '#263142'
  inverse-on-surface: '#ebf1ff'
  outline: '#74777e'
  outline-variant: '#c4c6cd'
  surface-tint: '#4f5f79'
  primary: '#04162c'
  on-primary: '#ffffff'
  primary-container: '#1a2b42'
  on-primary-container: '#8292ae'
  inverse-primary: '#b6c7e5'
  secondary: '#a83442'
  on-secondary: '#ffffff'
  secondary-container: '#fe757f'
  on-secondary-container: '#72081e'
  tertiary: '#121719'
  on-tertiary: '#ffffff'
  tertiary-container: '#272b2d'
  on-tertiary-container: '#8e9295'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#d4e3ff'
  primary-fixed-dim: '#b6c7e5'
  on-primary-fixed: '#0a1c32'
  on-primary-fixed-variant: '#374860'
  secondary-fixed: '#ffdada'
  secondary-fixed-dim: '#ffb3b5'
  on-secondary-fixed: '#40000b'
  on-secondary-fixed-variant: '#881c2c'
  tertiary-fixed: '#e0e3e6'
  tertiary-fixed-dim: '#c3c7ca'
  on-tertiary-fixed: '#181c1e'
  on-tertiary-fixed-variant: '#43474a'
  background: '#f9f9ff'
  on-background: '#111c2c'
  surface-variant: '#d8e3fa'
typography:
  display:
    fontFamily: Hanken Grotesk
    fontSize: 48px
    fontWeight: '800'
    lineHeight: 56px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Hanken Grotesk
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.01em
  headline-lg-mobile:
    fontFamily: Hanken Grotesk
    fontSize: 24px
    fontWeight: '700'
    lineHeight: 32px
  headline-md:
    fontFamily: Hanken Grotesk
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  body-sm:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
  label-md:
    fontFamily: JetBrains Mono
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.05em
  label-sm:
    fontFamily: JetBrains Mono
    fontSize: 10px
    fontWeight: '500'
    lineHeight: 12px
    letterSpacing: 0.05em
rounded:
  sm: 0.125rem
  DEFAULT: 0.25rem
  md: 0.375rem
  lg: 0.5rem
  xl: 0.75rem
  full: 9999px
spacing:
  base: 4px
  xs: 4px
  sm: 8px
  md: 16px
  lg: 24px
  xl: 40px
  container-max: 1280px
  gutter: 24px
---

## Brand & Style

This design system draws inspiration from the Panjalu PDF visual identity, characterized by its sharp, eagle-eyed precision and a balance of heritage and modernization. The brand personality is **authoritative, efficient, and sophisticated**. It is designed for professional document management, legal, or enterprise environments where clarity and trust are paramount.

The visual style is **Corporate / Modern** with a focus on high-density information architecture. It utilizes structured layouts, precise iconography, and a restrained but powerful color application to evoke a sense of reliability and institutional strength.

## Colors

The palette is derived directly from the primary brand mark. 

- **Primary (Deep Navy):** Extracted from the "PANJALU" logotype and the eagle silhouette. This is the foundational color for navigation, primary buttons, and headings.
- **Secondary (Oxblood Maroon):** Extracted from the "PDF" wing element. Used sparingly for calls to action, active states, and critical highlights to maintain visual hierarchy.
- **Backgrounds:** We utilize a "cool" neutral scale. The default background is a very light off-white/blue tint to reduce eye strain during long-form reading, typical of PDF workflows.
- **Success/Error:** Standard functional colors are modified to align with the palette's saturation—errors lean towards the secondary maroon, while successes use a deep emerald to match the primary's weight.

## Typography

The typography system mirrors the geometric and bold nature of the logo's typeface.

- **Headlines:** Use **Hanken Grotesk**. Its sharp terminals and wide apertures provide a modern, high-tech feel that reflects the "PDF" wing's precision.
- **Body:** Use **Inter**. Chosen for its exceptional legibility in data-heavy interfaces and document viewers.
- **Technical Data:** Use **JetBrains Mono** for metadata, file sizes, and document properties to reinforce the technical nature of the product.

All headings should use the Primary Deep Navy color to maintain a strong content hierarchy.

## Layout & Spacing

The layout philosophy is based on a **strict 4px grid system** to ensure mathematical precision in document alignment. 

- **Grid:** A 12-column fluid grid for desktop, transitioning to a 4-column grid for mobile.
- **Margins:** Desktop views should maintain generous side margins (80px+) to focus the eye on the central document/content area.
- **Density:** The system supports "Comfortable" and "Compact" modes. Compact mode reduces vertical padding in lists and tables by 50% for power users managing large file directories.

## Elevation & Depth

This design system avoids heavy shadows in favor of **Tonal Layers** and **Crisp Outlines**.

- **Surface Tiers:** Backgrounds use the Tertiary light tint. Content cards use pure white with a 1px border in a muted neutral-200.
- **Interaction Depth:** Instead of traditional shadows, "raised" elements (like an active document in a viewer) use a subtle 2px Primary Deep Navy bottom border or a very soft, high-diffusion "ambient" shadow (10% opacity) to signify focus.
- **Overlays:** Modals and dropdowns use a 1px solid border and a backdrop blur of 8px to maintain context while ensuring separation.

## Shapes

To match the professional and slightly "sharp" aesthetic of the eagle logo, the shape language is **Soft (Level 1)**.

- **Standard Components:** 4px (0.25rem) radius. This applies to buttons, inputs, and small cards.
- **Large Containers:** 8px (0.5rem) radius for main content areas.
- **Iconography:** Icons should feature square ends rather than rounded caps to align with the geometric nature of the brand's primary typeface.

## Components

### Buttons
- **Primary:** Solid Primary Deep Navy background with white text. No gradient. 
- **Secondary:** Solid Secondary Maroon background. Reserved for high-importance actions like "Convert" or "Sign."
- **Ghost:** Primary Deep Navy border (1px) with transparent background.

### Input Fields
- Use a light grey background (#F8FAFC) with a 1px bottom border that turns Primary Deep Navy on focus. 
- Labels use the `label-md` (Monospaced) style to denote a "form" or "data" entry state.

### Cards & Lists
- Document cards should feature a prominent file-type icon.
- Lists utilize alternating row stripes (Zebra striping) in the Tertiary color to improve horizontal scanning.

### Chips/Tags
- Rectangular with minimal rounding (2px). Use low-saturation backgrounds of the primary/secondary colors with high-saturation text for status indicators (e.g., "Draft", "Signed", "Pending").

### Document Viewer
- The workspace should be the most neutral area of the UI, using the Neutral scale to ensure the document content remains the focal point. Use the Primary color for the viewer's toolbar and action icons.