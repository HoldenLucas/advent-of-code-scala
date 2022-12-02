{
  inputs = {
    nixpkgs = { url = "github:NixOS/nixpkgs/nixpkgs-unstable"; };
    flake-utils = { url = "github:numtide/flake-utils"; };
  };

  outputs = inp:
    inp.flake-utils.lib.eachDefaultSystem (system:
      let
      in
      {
        devShell = pkgs.mkShell {
          buildInputs = with pkgs; [
            dotty
          ];
        };
      }
    );
}
