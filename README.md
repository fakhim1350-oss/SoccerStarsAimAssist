# Soccer Stars Aim Assist v3

A lightweight Android MediaProjection + overlay prototype. It samples frames at a limited rate and reduced resolution to avoid the memory/CPU crash observed in earlier builds. It detects a likely green playing area and bright ball-like point, draws a multi-bounce wall trajectory, and marks the final predicted point.

It does not automate taps or shots. Detection is heuristic and may need tuning for different game screens.
